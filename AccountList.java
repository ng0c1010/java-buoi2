package bai1;
import java.util.Scanner;
public class AccountList {
	 private Account[] accList;
	    private int count;
	    public AccountList() {
	        this.accList = new Account[10];
	        this.count = 0;
	    }
	    public AccountList(int size) {
	    	if (size > 0) {
	            this.accList = new Account[size];
	        } else {
	            this.accList = new Account[10];
	        }
	        this.count = 0;
	    }
	    public AccountList(Account[] accList) {
	        this.accList = accList;
	        this.count = accList.length;
	    }    
	    public boolean themTk(Account tk) {
	        if (count == accList.length) {
	            return false; 
	        }
	        accList[count++] = tk; 
	        return true;
	    }
	    public Account timTk (int acc) {
	    	for (int i = 0; i < count ; i++) {
	    		if( accList[i].getSoTk() == acc) {
	    			return accList[i];
	    		}
	    	}
	        return null;
	    }
	    public void xoaTk(int stk) {
	        Account[] tempAccList = new Account[accList.length];
	        int tempCount = 0;
	        for (int i = 0; i < count; i++) {
	            if (accList[i].getSoTk() != stk) {
	                tempAccList[tempCount] = accList[i];
	                tempCount++;
	            }
	        }
	        accList = tempAccList;
	        count = tempCount;
	    }
	    public int demSoTk() {
	        return count;
	    }    
	    public void inDanhSachTk() {
	        if (count == 0) {
	            System.out.println("Danh sach rong!");
	            return;
	        }
	        System.out.printf("%-10s %-20s %-20s %-20s\n", "So TK", "Ten TK", "So tien", "Trang thai");

	        for (int i = 0; i < count; i++) {
	            System.out.printf("%-10d %-20s %-20.2f %-20s\n", accList[i].getSoTk(), accList[i].getTenTk(),
	                accList[i].getSoTien(), accList[i].getTrangThai());
	        }
	    }
	    public boolean rutTien(int stk2, double soTien2) {
	        for(Account ac : accList) {
	            if(ac.getSoTk() == stk2) {
	                return ac.rutTien(soTien2);
	            }
	        }
	        return false;
	    }
	    public boolean napTien(int soTaiKhoan, double soTien) {
	        for (Account acc : accList) {
	            if (acc.getSoTk() == soTaiKhoan) {
	                acc.napTien(soTien, 0);
	                return true;
	            }
	        }
	        return false;
	    }    
	    public Account timTk1(int stk) {
	        for (int i = 0; i < demSoTk(); i++) {
	            if (accList[i].getSoTk() == stk) {
	                return accList[i];
	            }
	        }
	        return null;
	    }
	    public boolean chuyenTien(int stkGui, int stkNhan, double soTien) {
	        Account tkGui = timTk(stkGui);
	        Account tkNhan = timTk(stkNhan);

	        if (tkGui != null && tkNhan != null && tkGui.rutTien(soTien) && tkNhan.napTien(soTien, stkNhan)) {
	            System.out.println("Chuyển tiền thành công");
	            return true;
	        } else {
	            System.out.println("Không thể chuyển tiền");
	            return false;
	        }
	    }
	    public boolean kiemTraTienTrongTaiKhoan(int stk, double soTien) {
	        Account tk = timTk(stk);
	        if (tk != null && tk.getSoTien() >= soTien) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	    public void tinhLai() {
	        for (int i = 0; i < this.count; i++) {
	            Account tk = this.accList[i];
	            double lai = tk.tinhLai();
	            tk.napTien(lai, i);
	        }
	        System.out.println("Đã tính lãi cho tất cả các tài khoản");
	    }
}
