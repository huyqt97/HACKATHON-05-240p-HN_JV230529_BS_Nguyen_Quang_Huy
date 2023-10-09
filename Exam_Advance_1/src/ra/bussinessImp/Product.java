package ra.bussinessImp;

import ra.bussiness.IShop;
import ra.run.ProductManagement;

import java.util.Scanner;

import static ra.run.ProductManagement.catalogs;

public class Product implements IShop {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mã sản phẩm :");
        while (true) {
            String strId = sc.nextLine();
            if (!strId.trim().equals("")) {
                int id = Integer.parseInt(strId);
                if (ProductManagement.findByIdProduct(id) == null) {
                    this.productId = id;
                    break;
                } else {
                    System.out.println("mã sản phẩm đã tồn tại mời nhập lại!");
                }
            } else {
                System.out.println("Không được để trống mời nhập lại");
            }
        }
        System.out.println("Tên sản phẩm :");
        while (true) {
            String name = sc.nextLine();
            if (!name.trim().equals("")) {
                this.productName = name;
                break;
            } else {
                System.out.println("Không được để trống mời nhập lại!");
            }
        }
        System.out.println("Tiêu đề :");
        while (true) {
            String til = sc.nextLine();
            if (!til.trim().equals("")) {
                this.title = til;
                break;
            } else {
                System.out.println("Không được để trống mời nhập lại!");
            }
        }
        System.out.println("Mô tả sản phẩm :");
        while (true) {
            String des = sc.nextLine();
            if (!des.trim().equals("")) {
                this.descriptions = des;
                break;
            } else {
                System.out.println("Không được để trống mời nhập lại!");
            }
        }
        System.out.println("Danh mục sản phẩm :");
        ProductManagement.findAllCatalod();
        System.out.println("Nhập mã danh mục để lựa chọn");
        while (true) {
            int choice = Integer.parseInt(sc.nextLine());
            boolean check = false;
            for (int i = 0; i < catalogs.size(); i++) {
                if (catalogs.get(i).getCatalogId() == choice) {
                    this.catalog = catalogs.get(i);
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println("Không tìm thấy Mã danh mục mời chọn lại!");
            } else {
                break;
            }
        }
        System.out.println("Giá Nhập :");
        while (true) {
            String price = sc.nextLine();
            if (!price.trim().equals("")) {
                float imp = Float.parseFloat(price);
                if (imp > 0) {
                    this.importPrice = imp;
                    break;
                } else {
                    System.out.println("làm gì có giá đó nhập lại đi!");
                }
            } else {
                System.out.println("Không được để trống mời nhập lại!");
            }
        }
        System.out.println("giá bán :");
        System.out.println(this.importPrice * RATE);
        this.exportPrice = this.importPrice * RATE;
        System.out.println("Trạng thái sản phẩm (True (Còn hàng) or False(Hết hàng)) :");
        while (true) {
            String status = sc.nextLine().toLowerCase();
            if (status.equals("true") || status.equals("false")) {
                this.productStatus = Boolean.parseBoolean(status);
                break;
            }else {
                System.out.println("Phải chọn đúng theo yêu cầu (true or false) mời chọn lại!");
            }
        }
    }

    @Override
    public void displayData() {
        System.out.println("Mã sản phẩm : " + this.productId

                + " || Tên sản phẩm : " + this.productName
                + "|| Tên danh mục sảnh phẩm : " + this.catalog.getCatalogName()
                + " || GIá bán : " + this.exportPrice
                + " || Trạng thái : " + (this.productStatus ? "Còn hàng" : "Hết hàng"));
    }
}
