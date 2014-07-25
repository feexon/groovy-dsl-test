package com.lx2j.mailing.dsl

import com.lx2j.mailing.domain.Mail

/**
 * Created by L.x on 14-7-25.
 */
class MailDSLBuilder {
    private Mail mail = new Mail()

    static Mail mail(Closure closure = Closure.IDENTITY) {
        def builder = new MailDSLBuilder()
        closure.rehydrate(builder, builder, builder).call(builder);
        return builder.mail;
    }

    def from(String from) { mail.from = from; }

    def to(String to) { mail.to = to; }

    def subject(String subject) { mail.subject = subject; }

    def content(String content) { mail.content = content; }

    Mail getMail() {
        return mail;
    }
}
