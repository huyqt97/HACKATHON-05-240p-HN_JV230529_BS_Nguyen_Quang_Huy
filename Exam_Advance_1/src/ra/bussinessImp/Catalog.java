package ra.bussinessImp;

import ra.bussiness.IShop;
import ra.run.ProductManagement;

import java.util.Scanner;

public class Catalog implements IShop {
    private int catalogId;
    private String catalogName;
    private int priority;
    private String descriptions;
    private boolean catalogStatus;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, int priority, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã danh mục sản phẩm :");
        while (true) {
            String strId = sc.nextLine();
            if (!strId.trim().equals("")) {
                int id = Integer.parseInt(strId);
                if (ProductManagement.findByIdCatalog(id) == null) {
                    this.catalogId = id;
                    break;
                }else {
                    System.out.println("mã danh mục đã tồn tại mời nhập lại!");
                }
            } else {
                System.out.println("Không được để trống mời nhập lại");
            }
        }
        System.out.println("Tên danh mục sản phẩm :");
        while (true) {
            String name = sc.nextLine();
            if (!name.trim().equals("")) {
                this.catalogName = name;
                break;
            } else {
                System.out.println("Không được để trống mời nhập lại");
            }
        }
        System.out.println("Độ ưu tiên");
        while (true) {
            String pri = sc.nextLine();
            if (!pri.trim().equals("")) {
                this.priority = Integer.parseInt(pri);
                break;
            } else {
                System.out.println("Không được để trống mời nhập lại!");
            }
        }
        System.out.println("Mô tả danh mục :");
        while (true) {
            String des = sc.nextLine();
            if (!des.trim().equals("")) {
                this.descriptions = des;
                break;
            } else {
                System.out.println("Không được để trống mời nhập lại!");
            }
        }
        System.out.println("Trạng thái danh mục :");
        while (true) {
            String status = sc.nextLine().toLowerCase();
            if (status.trim().equals("true") || status.trim().equals("false")) {
                this.catalogStatus = Boolean.parseBoolean(status);
                break;
            }else {
                System.out.println("Phải chọn đúng theo yêu cầu (true or false) mời chọn lại!");
            }
        }
    }

    @Override
    public void displayData() {
        System.out.println("Mã danh mục :" + this.catalogId + " || Tên danh mục :" + this.catalogName);
    }
}
