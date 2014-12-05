package uk.ac.ebi.pride.archive.wsclient.config;

/**
 * @author Jose A. Dianes <jadianes@gmail.com>
 * @author ypriverol
 *
 */
public abstract class AbstractArchiveWsConfig {

    private String hostName;
    private String protocol;

    protected AbstractArchiveWsConfig(String protocol, String hostName) {
        this.hostName = hostName;
        this.protocol = protocol;
    }

    public String getHostName() {
        return hostName;
    }


    public String getProtocol() {
        return protocol;
    }

}
