package PostSystem;

public class Inspector implements MailService{
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";
    public final String[] illegalSubstances= {WEAPONS, BANNED_SUBSTANCE};

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            Package realPackage = ((MailPackage) mail).getContent();

            for (String illegalSubstance : illegalSubstances) {
                if (illegalSubstance.equals(realPackage.getContent())) {
                    try {
                        throw new IllegalPackageException("In the package discovered forbidden content");
                    } catch (IllegalPackageException e) {
                        e.printStackTrace();
                    }
                }
            }


            if (realPackage.getContent().contains("stones")) {
                try {
                    throw new StolenPackageException("Discovered the theft from the parcel!");
                } catch (StolenPackageException e) {
                    e.printStackTrace();
                }
            }
        }
        return mail;
    }
}

class IllegalPackageException extends RuntimeException {
    public IllegalPackageException (String message) {
        super(message);
    }
}

class StolenPackageException extends RuntimeException {
    public StolenPackageException (String message) {
        super(message);
    }
}