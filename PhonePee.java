
import java.io.*;
import java.util.*;

public class PhonePee {
}



// Main class should be named 'Solution' and should not be public.
class Solution {
    public static void main(String[] args) {
        System.out.println("Hello, World");
    }
}

class Address {

}

class User {

    private int id;

    private String name;

    private String email;

    private String contactNumber;

    private Address address;

    private String password;

    private transient String confirmPassword;

    private Cart cart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}


class Cart {

    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int id) {

    }

    public List<Product> getProducts() {
        return products;
    }
}

class Product {

    private int id;

    private String name;

    private String brand;

    private String description;

    private int price;

    private int quantity;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }


    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

class RegistrationController {

    public boolean userRegistration(User user) {
        UserService service = UserServiceImpl.getInstance();
        boolean result = service.registration(user);
        if (!result) {
            return false;
        }
        return true;
    }

}

class LoginController {

    public boolean loginAdmin(String userName, String password) {
        System.out.println();
        try {
            String token = userName + password;
            // Validate
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean loginUser(String email, String password) {
        try {
            String token = email + password;
            // Validate
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}


class CartController {

    public Cart showCart() {

        CartService service = CartServiceImpl.getInstance();
        Cart cart = service.getCart();
        if (cart.getProducts().isEmpty()) {
            // We have to handle empty case;
        }
        return cart;
    }

    public boolean addCart(Product product) {

        CartService service = CartServiceImpl.getInstance();
        Product product1 = ProductServiceImpl.getInstance().findProductById(product.getId());
        if (product.getQuantity() > product1.getQuantity()) {
            // We have to handle error case;
        }
        boolean isAdded = service.saveCart(product);
        if (!isAdded) {
            return false;
        }
        return true;
    }

    public boolean updateCart(Product product) {

        CartService service = CartServiceImpl.getInstance();
        boolean isUpdated = service.updateCart(product);
        if (!isUpdated) {
            return false;
        }
        return true;
    }

    public boolean removeCart(Product product) {

        CartService service = CartServiceImpl.getInstance();
        boolean isDeleted = service.removeCartProduct(product);
        if (!isDeleted) {
            return false;
        }
        return true;
    }
}


class ProductController {

    public Product getProduct(int productId) {
        ProductService service = ProductServiceImpl.getInstance();
        Product product = service.findProductById(productId);
        if (product == null) {
            // Handle Error case
        }
        return product;
    }

    public List<Product> getProducts() {
        ProductService service = ProductServiceImpl.getInstance();
        List<Product> products = service.findAllProductsForAdmin();
        if (products.isEmpty()) {
            // Handle error case
        }
        return products;
    }


    public boolean addProduct(Product product) {
        ProductService service = ProductServiceImpl.getInstance();
        boolean isAdd = service.saveProduct(product);
        if (!isAdd) {
            return false;
        }
        return true;
    }


    public boolean updateProduct(int productId, Product product) {
        product.setId(productId);
        ProductService service = ProductServiceImpl.getInstance();
        Product updatedProduct = service.update(product);
        if (updatedProduct == null) {
            return false;
        }
        return true;
    }


    public boolean removeProduct(int productId) {
        ProductService service = ProductServiceImpl.getInstance();
        boolean isDelete = service.deleteProduct(productId);
        if (!isDelete) {
            return false;
        }
        return true;
    }
}


interface CartService {

    Cart getCart();

    boolean saveCart(Product product);

    boolean updateCart(Product product);

    boolean removeCartProduct(Product product);
}

class CartServiceImpl implements CartService {

    private static CartServiceImpl instance;

    private CartServiceImpl() {

    }

    public static CartServiceImpl getInstance() {
        if (instance == null) {
            instance = new CartServiceImpl();
        }
        return instance;
    }

    @Override
    public boolean saveCart(Product product) {
        CartDao dao = CartDao.getInstance();
        User user = UserHandler.getUser();
        int userId = user.getId();
        ProductService service = ProductServiceImpl.getInstance();
        Product product1 = service.findProductById(product.getId());
        try {
            int isAdd = dao.add(userId, product);
            if (isAdd != 0) {
                int quantity = product1.getQuantity() - product.getQuantity();
                product1.setQuantity(quantity);
                service.updateProduct(product1);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Cart getCart() {
        Cart cart = null;
        User user = UserHandler.getUser();
        int userId = user.getId();
        try {
            cart = CartDao.getInstance().getAll(userId);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public boolean updateCart(Product product) {

        CartDao cart = CartDao.getInstance();
        User user = UserHandler.getUser();
        int userId = user.getId();

        try {
            int cartQuantity = cart.get(userId, product.getId());
            int quan = product.getQuantity() - cartQuantity;
            ProductService service = ProductServiceImpl.getInstance();
            Product product1 = service.findProductById(product.getId());
            if (quan > product1.getQuantity()) {
                return false;
            }
            if (product1.getQuantity() >= quan) {
                int newQuantity = product1.getQuantity() - quan;
                product1.setQuantity(newQuantity);
                cart.update(userId, product);
                ProductDaoImpl.getInstance().update(product1);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeCartProduct(Product product) {
        CartDao dao = CartDao.getInstance();
        User user = UserHandler.getUser();
        int userId = user.getId();

        ProductDao productDao = ProductDao.getInstance();
        try {
            int quantity  = dao.get(userId, product.getId());
            product.setQuantity(quantity);
            int isUpdate = productDao.updateProduct(product);
            int isDeleted = dao.delete(userId, product);
            if (isDeleted != 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

interface ProductService {

    boolean saveProduct(Product product);

    List<Product> findAllProducts();

    List<Product> findAllProductsForAdmin();

    Product findProductById(int id);

    boolean deleteProduct(int id);

    Product updateProduct(Product product);

    Product update(Product product);
}

class ProductServiceImpl implements ProductService {

    private static ProductServiceImpl instance;

    private ProductServiceImpl() {

    }

    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    @Override
    public boolean saveProduct(Product product) {
        ProductDao dao = ProductDao.getInstance();
        try {
            int isAdd = dao.add(product);
            if (isAdd != 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> findAllProducts() {
        List<Product> products = null;
        ProductDao dao = ProductDao.getInstance();
        try {
            products = dao.getAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> findAllProductsForAdmin() {
        List<Product> products = new ArrayList<>();

        return products;
    }

    @Override
    public Product findProductById(int productId) {

        Product product = null;
        ProductDao dao = ProductDao.getInstance();
        try {
            product = dao.get(productId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean deleteProduct(int productId) {
        ProductDao dao = ProductDao.getInstance();
        try {
            int isDeleted = dao.delete(productId);
            if (isDeleted != 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product updateProduct(Product product) {
        ProductDao dao = ProductDao.getInstance();
        try {
            int isUpdate = dao.update(product);
            if (isUpdate != 0) {
                return findProductById(product.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product update(Product product) {
        ProductDao dao = ProductDao.getInstance();
        try {
            int isUpdate = dao.updateProduct(product);
            if (isUpdate != 0) {
                return findProductById(product.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}


class CartDao {

    private Map<Integer, Cart> cart = new HashMap<>();
    public static CartDao instance;

    private CartDao() {

    }

    public static CartDao getInstance() {
        if (instance == null) {
            instance = new CartDao();
        }
        return instance;
    }

    public Cart get(int userId) {
        return cart.get(userId);
    }


    public int add(int userId, Product prod) {
        return 0;
    }

    public int update(int userId, Product product) {

        return 0;
    }

    public int delete(int userId, Product product) {
        return 0;
    }

}

class ProductDao {

    private static ProductDao instance;

    private ProductDao() {

    }

    public static ProductDao getInstance() {
        if (instance == null) {
            instance = new ProductDao();
        }
        return instance;
    }

    public Product get(int productId) {
        return null;
    }

    public List<Product> getAll() {
        return null;
    }

    public boolean add(Product product) {
        return true;
    }

    public boolean update(Product product) {
        return true;
    }

    public boolean delete(int productId) {
        return true;
    }
}

class UserHandler {

    private static final ThreadLocal<User> context = new ThreadLocal<>();

    public static void setUser(User user) {
        context.set(user);
    }

    public static User getUser() {
        return context.get();
    }

    public static void removeUser() {
        context.remove();
    }

}