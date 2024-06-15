package DailyPratice;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class AppTest {

    @Test
    public void testExample() throws IOException, MailosaurException {
        // API key and server details
        String apiKey = "hprbbMqDVkGhdbfKvWCekNKcvLsxh2Mc";
        String serverId = "ao4dhyrb";
        String serverDomain = "know-sunlight@ao4dhyrb.mailosaur.net";
        //
        // Initialize Mailosaur client
        MailosaurClient mailosaur = new MailosaurClient(apiKey);
        // Set search parameters
        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverId);
        // Set search criteria
        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo("know-sunlight@" + serverDomain);
        Message message=mailosaur.messages().get(params, criteria);
        System.out.println(message.subject());
        System.out.println(message.cc());
        System.out.println(message.bcc());
        System.out.println(message.text().body());
        System.out.println(message.to().get(0).email());
        System.out.println(message.from().get(0).email());
        //body
        System.out.println("---body---");
        System.out.println(message.text().body());
        assertTrue(message.text().body().contains("hello"));
        //subject
        System.out.println("---subject---");
        System.out.println(message.subject());
        System.out.println("===links===");
        assertNotNull(message);
        assertEquals("hello", message.subject());






    }
}
