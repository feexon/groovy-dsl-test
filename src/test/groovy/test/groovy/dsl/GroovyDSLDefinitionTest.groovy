package test.groovy.dsl

import com.lx2j.mailing.domain.Mail
import com.lx2j.mailing.dsl.MailDSLBuilder
import org.junit.Test

import static com.lx2j.mailing.dsl.MailDSLBuilder.mail

/**
 * Created by L.x on 14-7-25.
 */
class GroovyDSLDefinitionTest {
    Mail sent;

    void send(Mail mail) {
        sent = mail;
    }

    @Test
    public void send_an_empty_mail() throws Exception {
        send mail();
        assert sent instanceof Mail;
    }

    @Test
    public void send_mail() throws Exception {
        send mail {
            from 'Lx@gmail.com'
            to 'github@gmail.com'
            subject 'Groovy DSL Definition'
            content 'A Simple Groovy DSL Definition'
        };

        assert sent.from == 'Lx@gmail.com'
        assert sent.to == 'github@gmail.com'
        assert sent.subject == 'Groovy DSL Definition'
        assert sent.content == 'A Simple Groovy DSL Definition'
    }
}
