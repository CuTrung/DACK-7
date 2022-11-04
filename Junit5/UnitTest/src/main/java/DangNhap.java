import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DangNhap {

    private String email;
    private String matKhau;

    private boolean coThanhCong;

    // Thiết lập giá trị mặc định là rỗng cho email và mật khẩu
    public void setDefault(){
        this.email = "";
        this.matKhau = "";
    }


    public DangNhap(DangKi dk, String email, String matKhau) {
        // Đăng kí thành công mới cho đăng nhập hoặc tồn tại tài khoản mới cho đăng nhập
        if(dk.trangThai()){
            setEmail(email);
            setMatKhau(matKhau);

            // So sánh xem có khớp email và password có khớp với tài khoản đã có
            if(dk.getEmail().equalsIgnoreCase(email) && dk.getMatKhau().equalsIgnoreCase(matKhau)){
                setCoThanhCong(true);
            } else {
                setCoThanhCong(false);
            }

        }

    }



    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    // Kiểm tra email nhập vào hợp lệ hay không
    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.isEmpty()){
            System.out.println("Email ko duoc de trong");
        } else if (validate(email)){
            this.email = email;
        } else {
            System.out.println("Dinh dang Email ko hop le");
        }

    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        if(matKhau.isEmpty()){
            System.out.println("Mat khau ko duoc de trong");
            return;
        }
        this.matKhau = matKhau;
    }

    public void setCoThanhCong(boolean coThanhCong) {
        this.coThanhCong = coThanhCong;
    }

    // Trả về trạng thái sau khi đăng nhập (true: thành công, false: thất bại)
    public boolean trangThai(){
        return this.coThanhCong;
    }
}
