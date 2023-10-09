package ra.run;

import ra.bussiness.IShop;
import ra.bussinessImp.Catalog;
import ra.bussinessImp.Product;

import java.util.*;

public class ProductManagement {
    private static Scanner sc = new Scanner(System.in);
    public static List<Catalog> catalogs = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************\n" +
                    "1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục [10 điểm]\n" +
                    "2. Nhập số sản phẩm và nhập thông tin các sản phẩm [20 điểm]\n" +
                    "3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator) [10 điểm]\n" +
                    "4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm [05 điểm]\n" +
                    "5. Thoát [05 điểm]\n");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addCatalog();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    sortToPriceASC();
                    break;
                case 4:
                    searchProductToNameCatalog();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ mời nhập lại!");
            }
        }
    }


    public static void addCatalog() {
        System.out.println("Nhập số danh mục mới :");
        while (true) {
            int nb = Integer.parseInt(sc.nextLine());
            if (nb > 0) {
                for (int i = 0; i < nb; i++) {
                    System.out.println("Danh mục " + (i + 1) + " : ");
                    Catalog catalog = new Catalog();
                    catalog.inputData();
                    catalogs.add(catalog);
                }
                System.out.println("Thêm mới thành công!");
                break;
            } else {
                System.out.println("Nhập lại số lượng muốn thêm mới!");
            }
        }
    }

    public static void findAllCatalod() {
        boolean check = false;
        for (int i = 0; i < catalogs.size(); i++) {
            if (catalogs.get(i) != null) {
                System.out.println("Danh mục " + (i + 1) + " : ");
                catalogs.get(i).displayData();
                check = true;
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy danh mục mời nhập lại!");
        }
    }
    public static Catalog findByIdCatalog(int id){
        for (Catalog ca :
                catalogs) {
            if(ca.getCatalogId() == id){
                return ca;
            }
        }
        return null;
    }
    public static void addProduct() {
        System.out.println("Nhập số sản phẩm mới :");
        while (true) {
            int nb = Integer.parseInt(sc.nextLine());
            if (nb > 0) {
                for (int i = 0; i < nb; i++) {
                    Product product = new Product();
                    System.out.println("Sản phẩm thứ " + (i + 1) + " : ");
                    product.inputData();
                    products.add(product);
                }
                System.out.println("Thêm mới thành công!");
                break;
            } else {
                System.out.println("Nhập lại số lượng thêm mới!");
            }
        }
    }
    public static Product findByIdProduct(int id){
        for (Product product :
                products) {
            if(product.getProductId() == id){
                return product;
            }
        }
        return null;
    }
    public static void sortToPriceASC() {
        Collections.sort(products, new Comparator<IShop>() {
            @Override
            public int compare(IShop product1, IShop product2) {
                return Float.compare(((Product) product1).getExportPrice(), ((Product) product2).getExportPrice());
            }
        });
        System.out.println("Danh sách đã được sắp xếp theo giá tăng dần.");
        for (Product product : products) {
            product.displayData();
        }
    }

    public static void searchProductToNameCatalog() {
        System.out.println("Nhập tên sản phẩm muốn tìm :");
        String catalogName = sc.nextLine().toLowerCase();
        boolean check = false;
        for (Product product :
                products) {
            if (product.getCatalog().getCatalogName().contains(catalogName)) {
                product.displayData();
                check = true;
            }
            ;
        }
        if (!check) {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }
}
