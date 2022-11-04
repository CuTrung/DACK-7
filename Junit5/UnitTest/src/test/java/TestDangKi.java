import org.junit.Assert;
import org.junit.Test;

public class TestDangKi {

    @Test
    public void deTrongHo(){
        DangKi dk = new DangKi("", "Van A", "test@gmail.com", "Abc123456");
        Assert.assertFalse(dk.trangThai());

    }

    @Test
    public void deTrongTen(){
        DangKi dk = new DangKi("Nguyen", "", "test@gmail.com", "Abc123456");
        Assert.assertFalse(dk.trangThai());
    }

    @Test
    public void deTrongEmail(){
        DangKi dk = new DangKi("Nguyen", "Van A", "", "Abc123456");
        Assert.assertFalse(dk.trangThai());
    }

    @Test
    public void deTrongMk(){
        DangKi dk = new DangKi("Nguyen", "Van A", "test@gmail.com", "");
        Assert.assertFalse(dk.trangThai());
    }

    @Test
    public void nhapEmailSaiDinhDang(){
        DangKi dk = new DangKi("Nguyen", "Van A", "test", "Abc123456");
        Assert.assertFalse(dk.trangThai());
    }





}
