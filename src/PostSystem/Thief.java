package PostSystem;

public class Thief implements MailService{
    protected final int packageValue;
    protected int stolenValue = 0;

    public Thief(int packageValue) {
        this.packageValue = packageValue;
    }

    public int getStolenValue() {
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            Package realPackage = ((MailPackage) mail).getContent();
            if(realPackage.getPrice() >= packageValue) {
                stolenValue += realPackage.getPrice();
                return new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of " + realPackage.getContent(), 0));
            }
            return mail;
        }
        return mail;
    }
}
