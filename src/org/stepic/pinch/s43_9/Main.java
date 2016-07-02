package org.stepic.pinch.s43_9;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static void main(String[] args) {

    }

    public static  interface Sendable {
        String getFrom();
        String getTo();
    }

    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        protected AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (from != null ? !from.equals(that.from) : that.from != null) return false;
            return to != null ? to.equals(that.to) : that.to == null;

        }
    }

    public static class MailMessage extends AbstractSendable {

        private final String message;

        protected MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage(){
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            if (message != null ? !message.equals(that.message) : that.message != null) return false;

            return true;
        }
    }


    public static class MailPackage extends AbstractSendable {

        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent(){
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            if (!content.equals(that.content)) return false;

            return true;
        }
    }

    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;

            return true;
        }
    }

    public static interface MailService {
        Sendable processMail(Sendable mail);
    }

    public static class RealMailService implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            return mail;
        }
    }

    public static class UntrustworthyMailWorker implements MailService{

        private final MailService[] mailServices;
        private final MailService realMailService = new RealMailService();

        public UntrustworthyMailWorker(MailService[] mailServices) {
            this.mailServices = mailServices;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for (MailService mailService:mailServices) {
                mail = mailService.processMail(mail);
            }
            return realMailService.processMail(mail);
        }

        public MailService getRealMailService(){
            return realMailService;
        }
    }

    public static class Spy implements MailService{

        private final MailService realMailService = new RealMailService();
        private final Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if(mail instanceof MailMessage){
                if(mail.getFrom().equals(AUSTIN_POWERS) || mail.getTo().equals(AUSTIN_POWERS)){
                    logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"", new Object[]{mail.getFrom(), mail.getTo(), ((MailMessage)mail).getMessage()});
                }else{
                    logger.log(Level.INFO, "Usual correspondence: from {0} to {1}", new Object[]{mail.getFrom(), mail.getTo()});
                }
            }
            return realMailService.processMail(mail);
        }
    }

    public static class Thief implements MailService{

        private final MailService realMailService = new RealMailService();
        private final int minPrice;
        private int stolenValue = 0;

        public Thief(int minPrice) {
            this.minPrice = minPrice;
        }

        public int getStolenValue(){
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if(mail instanceof MailPackage){
                Package p = ((MailPackage) mail).getContent();
                if(p.getPrice() >= minPrice){
                    stolenValue += p.getPrice();
                    mail = new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of "+p.getContent(), 0));
                }
            }
            return realMailService.processMail(mail);
        }
    }

    public static class Inspector implements MailService {

        private final MailService realMailService = new RealMailService();
        private final String[] forbiddenContent = new String[]{WEAPONS, BANNED_SUBSTANCE};

        @Override
        public Sendable processMail(Sendable mail) {
            if(mail instanceof MailPackage) {
                for (String forbiddenWord : forbiddenContent) {
                    if (((MailPackage) mail).getContent().getContent().contains(forbiddenWord))
                        throw new IllegalPackageException();
                    else if(((MailPackage) mail).getContent().getContent().contains("stones"))
                        throw new StolenPackageException();
                }
            }
            return realMailService.processMail(mail);
        }
    }

    public static class IllegalPackageException extends RuntimeException{}
    public static class StolenPackageException extends RuntimeException{}
}
