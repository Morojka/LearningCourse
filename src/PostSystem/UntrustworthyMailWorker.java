package PostSystem;

public class UntrustworthyMailWorker implements MailService {
    protected final MailService[] thirdPartyServices;
    protected final RealMailService realMailService;

    public UntrustworthyMailWorker(MailService[] thirdPartyServices) {
        this.thirdPartyServices = thirdPartyServices;
        this.realMailService = new RealMailService();
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService thirdPartyService : thirdPartyServices) {
            mail = thirdPartyService.processMail(mail);
        }

        return realMailService.processMail(mail);
    }

    public RealMailService getRealMailService() {
        return realMailService;
    }
}