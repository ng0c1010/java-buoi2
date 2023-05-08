package bai1;
import java.util.Scanner;
public class AccountTest {
	public static void main(String[] args) {
		AccountList list = new AccountList(10);
		Account acc1 = new Account ("Ted Murphy", 72354, 100000, "Mở");
		Account acc2 = new Account ("Jane Smith", 69731, 40000, "Mở");
		Account acc3 = new Account ("Edward Demsey", 93753, 700000, "Mở");
		list.themTk(acc1);
		list.themTk(acc2);
		list.themTk(acc3);
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("----- MENU -----");
	            System.out.println("1. Thêm tài khoản");
	            System.out.println("2. Số tài khoản hiện có");
	            System.out.println("3. In thông tin tất cả tài khoản");
	            System.out.println("4. Nạp tiền vào tài khoản");
	            System.out.println("5. Rút tiền khỏi tài khoản");
	            System.out.println("6. Chuyển tiền từ tài khoản này sang tài khoản khác");
	            System.out.println("7. Kết thúc");

	            int choice = scanner.nextInt();

	            switch (choice) {          
	            case 1:
	                System.out.println("Nhập tên tài khoản: ");
	                scanner.nextLine();
	                String tenTk = scanner.nextLine();
	                System.out.println("Nhập số tài khoản: ");
	                int soTk = scanner.nextInt();
	                System.out.println("Nhập số tiền: ");
	                double soTien = scanner.nextDouble();
	                scanner.nextLine();
	                System.out.println("Nhập trạng thái: ");
	                String trangThai = scanner.nextLine();
	                Account tk = new Account(tenTk, soTk, soTien, trangThai);
	                if (list.themTk(tk)) {
	                    System.out.println("Thêm tài khoản thành công");
	                } else {
	                    System.out.println("Không thể thêm tài khoản");
	                }
	                break;
	                case 2:
	                    System.out.println("Tổng số tài khoản hiện có là: " + list.demSoTk());
	                    break;

	                case 3:
	                    list.inDanhSachTk();
	                   
	                    break;

	                case 4:
	                    System.out.println("Nhập số tài khoản cần nạp tiền: ");
	                    int stk1 = scanner.nextInt();
	                    System.out.println("Nhập số tiền cần nạp: ");
	                    double soTien1 = scanner.nextDouble();
	                    if (list.napTien(stk1, soTien1)) {
	                        System.out.println("Cảm ơn bạn đã sử dụng dịch vụ");
	                    } else {
	                        System.out.println("Không thể nạp tiền");
	                    }
	                    break;

	                case 5:
	                    System.out.println("Nhập số tài khoản cần rút tiền: ");
	                    int stk2 = scanner.nextInt();
	                    scanner.nextLine();
	                    System.out.println("Nhập số tiền cần rút: ");
	                    double soTien2 = scanner.nextDouble();
	                    if (list.rutTien(stk2, soTien2)) {
	                        System.out.println("Cảm ơn bạn đã sử dụng dịch vụ");
	                    } else {
	                        System.out.println("Không thể rút tiền");
	                    }
	                    break;
	                case 6:
	                    System.out.println("Nhập số tài khoản nguồn: ");
	                    int stkNguon = scanner.nextInt();
	                    scanner.nextLine();
	                    System.out.println("Nhập số tài khoản đích: ");
	                    int stkDich = scanner.nextInt();
	                    scanner.nextLine();
	                    System.out.println("Nhập số tiền cần chuyển: ");
	                    double soTienChuyen = scanner.nextDouble();
	                    scanner.nextLine();
	                    if (list.chuyenTien(stkNguon, stkDich, soTienChuyen)) {
	                        System.out.println("Chuyển tiền thành công");
	                    } else {
	                        System.out.println("Không thể chuyển tiền");
	                    }
	                    break;
	                case 7:
	                	System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!!");
	                	break;
	                case 8:	
	                	list.tinhLai();
	                	break;
	                default:
	                    System.out.println("Lựa chọn không hợp lệ");
	                    break;               
	}
}
  }
	}
