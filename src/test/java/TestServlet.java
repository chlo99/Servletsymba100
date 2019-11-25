import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import static org.mockito.Mockito.*;

public class TestServlet {
    @Mock
    HttpServletRequest req;
    @Mock
    HttpServletResponse resp;

    @Test
    public void testResponse() throws IOException, ServletException {
        StringWriter stringwriter= new StringWriter();
        PrintWriter printwriter=new PrintWriter(stringwriter);
        when(resp.getWriter()).thenReturn(printwriter);

        MyServlet test1= new MyServlet();
        test1.doGet(req, resp);

        String output=stringwriter.getBuffer().toString();
        Assert.assertEquals("Hello world!", output);
    }
}
