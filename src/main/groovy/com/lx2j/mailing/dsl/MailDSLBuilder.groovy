package com.lx2j.mailing.dsl

import com.lx2j.mailing.domain.Mail

/**
 * Created by L.x on 14-7-25.
 */
class MailDSLBuilder implements GroovyInterceptable {
    private Mail mail = new Mail()

    static Mail mail(Closure closure = Closure.IDENTITY) {
        def builder = new MailDSLBuilder()
        closure.rehydrate(builder, builder, builder).call(builder);
        return builder.mail;
    }


    @Override
    Object invokeMethod(String name, def args) {
        mail[name] = args.first();
    }

}
