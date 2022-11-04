import org.junit.Assert;
import org.junit.Test;

public class TestDangNhap {

    @Test
    public void deTrongEmail(){
        DangNhap dn = new DangNhap(new DangKi(), "", "Abc123456");
        Assert.assertFalse(dn.trangThai());
    }

    @Test
    public void deTrongMk(){
        DangNhap dn = new DangNhap(new DangKi(), "test@gmail.com", "");
        Assert.assertFalse(dn.trangThai());
    }

    @Test
    public void nhapEmailKhongHopLe(){
        DangNhap dn = new DangNhap(new DangKi(), "test", "Abc123456");
        Assert.assertFalse(dn.trangThai());
    }

    @Test
    public void chuaDangKi(){
        DangNhap dn = new DangNhap(new DangKi(), "test123@gmail.com", "Abc123456");
        Assert.assertFalse(dn.trangThai());
    }

    @Test
    public void nhapEmailVaMatKhauDaDangKi(){
        DangNhap dn = new DangNhap(new DangKi("Nguyen", "Van A", "test@gmail.com", "Abc123456"),
                                                                        "test@gmail.com", "Abc123456");
        Assert.assertTrue(dn.trangThai());
    }

    @Test
    public void nhapEmailVaMatKhauSai(){
        DangNhap dn = new DangNhap(new DangKi("Nguyen", "Trung", "123@gmail.com", "123456"),
                                                "123@gmail.com", "12");
        Assert.assertFalse(dn.trangThai());
    }
}
