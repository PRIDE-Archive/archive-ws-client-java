package uk.ac.ebi.pride.archive.wsclient.config;

/**
 * @author Jose A. Dianes <jadianes@gmail.com>
 *
 */
public class ArchiveWsConfig {

    private String hostName;
    private String protocol;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
