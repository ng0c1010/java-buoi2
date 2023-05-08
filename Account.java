package bai1;
import java.text.NumberFormat;
import java.util.Scanner;
public class Account {
	private double soTien;
	private int soTk;
	private String tenTk;
	private String trangThai;
    private static final double laiSuat = 0.035;
	public Account() {
        this.soTk = 999999;
        this.tenTk = "Chưa xác định";
        this.soTien = 50.0;
        this.trangThai = "Mở";
    }
	public Account(String tenTk, int soTk,double soTien,  String trangThai) {
		 if (soTien >= 50.0) {
	            this.soTien = soTien;
	        } else {
	            this.soTien = 50.0;
	            this.trangThai = "Số tiền không hợp lệ";
	        }
		if (soTk > 0 && soTk != 999999) {
	            this.soTk = soTk;
	        } else {
	            this.soTk = 999999;
	            this.trangThai = "Số tài khoản không hợp lệ";
	        }

	        if (tenTk != null && !tenTk.isEmpty()) {
	            this.tenTk = tenTk;
	        } else {
	            this.tenTk = "Chưa xác định";
	            this.trangThai = "Tên tài khoản không hợp lệ";
	        }
	        this.trangThai = "Mở";
	}
	public double getSoTien() {
		return soTien;
	}
	public void setSoTien(double soTien) {
		if (soTien >= 50) {
			this.soTien = soTien;
		}else {
			this.soTien = 50;
			this.trangThai = "Số tiền không hợp lệ";
		}
	}
	public int getSoTk() {
		return soTk;
	}
	public void setSoTk(int soTk) {
		if (soTk > 0 && soTk != 999999 ) {
			this.soTk = soTk;
		}else {
			this.soTk = 999999;
            this.trangThai = "Số tài khoản không hợp lệ";
		}
	}
	public String getTenTk() {
		return tenTk;
	}
	public void setTenTk(String tenTk) {
		this.tenTk = tenTk;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	 public String getSotienFormatted() {
	        NumberFormat formatter = NumberFormat.getCurrencyInstance();
	        return formatter.format(soTien);
	    } 
	 @Override
	    public String toString() {
	        return "Tài khoản " + soTk + ": " + tenTk + " - Số dư: " + String.format("%,.2f", soTien) + " đồng";
	    }
	 public boolean napTien(double soTienNap, int i) {
		    if (soTienNap <= 0) {
		        System.out.println("So tien nap phai lon hon 0");
		    } else {
		        soTien += soTienNap;
		        System.out.println("Nap tien thanh cong");
		        return true;
		    }
		    return false;
		}
	 public boolean rutTien(double soTienRut) {
		    if (soTienRut <= 0) {
		        System.out.println("So tien rut phai lon hon 0");
		    } else if (soTienRut > soTien) {
		        System.out.println("So du khong du de rut tien");
		    } else {
		        soTien -= soTienRut;
		        System.out.println("Rut tien thanh cong");
		        return true; // 
		    }
		    return false;
		}
	public void transfer(Account account, double amount) {
	    if (this.soTien >= amount && amount >= 50) {
	        this.soTien -= amount;
	        account.soTien += amount;
	        this.trangThai = "Chuyển khoản thành công " + String.format("%.2f", amount) + " đến tài khoản " + account.tenTk;
	    } else {
	        this.trangThai = "Chuyển khoản thất bại";
	    }
	}
	public void daoHan() {
	    double tienLai = this.soTien * laiSuat;
	    this.soTien += tienLai;
	    this.trangThai = "Đáo hạn thành công, lãi suất là " + String.format("%.2f", tienLai);
	}
}
