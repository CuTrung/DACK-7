import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DangKi {
    private String ho;
    private String ten;
    private String email;
    private String matKhau;

    private boolean coThanhCong;

    // Thiết lập giá trị mặc định là rỗng cho họ, tên, email, mật khẩu
    public void setDefault(){
        this.ho = "";
        this.ten = "";
        this.email = "";
        this.matKhau = "";
    }

    public DangKi(){
        setDefault();
    }

    public DangKi(String ho, String ten, String email, String matKhau) {

        setDefault();

        setHo(ho);
        setTen(ten);
        setEmail(email);
        setMatKhau(matKhau);

        // Kiểm tra xem có trường nào trống không
        if( this.ho.equals("")|| this.ten.equals("") || this.email.equals("") || this.matKhau.equals("")){
            setCoThanhCong(false);
        } else {
            setCoThanhCong(true);
        }

    }


    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        if(ho.isEmpty()){
            System.out.println("Ho ko duoc de trong");
            return;
        }
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        if(ten.isEmpty()){
            System.out.println("Ten ko duoc de trong");
            return;
        }
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    // Kiểm tra email nhập vào hợp lệ hay không
    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
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
            System.out.println("Mat Khau ko duoc de trong");
            return;
        }
        this.matKhau = matKhau;
    }

    public void setCoThanhCong(boolean coThanhCong) {
        this.coThanhCong = coThanhCong;
    }

    // Trả về trạng thái sau khi đăng kí (true: thành công, false: thất bại)
    public boolean trangThai(){
       return this.coThanhCong;
    }


}
