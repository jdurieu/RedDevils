package com.jdurieu.reddevils.app.model;

public class DetailPlayer {

    public static class DetailPlayerData {
        private String c_EmblemImage;
        private String c_Headline;
        private String c_Summary;

        public DetailPlayerData() {

        }

        public String getC_EmblemImage() {
            return c_EmblemImage;
        }

        public void setC_EmblemImage(String c_EmblemImage) {
            this.c_EmblemImage = c_EmblemImage;
        }

        public String getC_Headline() {
            return c_Headline;
        }

        public void setC_Headline(String c_Headline) {
            this.c_Headline = c_Headline;
        }

        public String getC_Summary() {
            return c_Summary;
        }

        public void setC_Summary(String c_Summary) {
            this.c_Summary = c_Summary;
        }
    }

    public DetailPlayerData data;
    private String expires;
    private String expiresSource;
    private String lastModified;
    private String success;

    public DetailPlayerData getData() {
        return data;
    }

    public void setData(DetailPlayerData data) {
        this.data = data;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getExpiresSource() {
        return expiresSource;
    }

    public void setExpiresSource(String expiresSource) {
        this.expiresSource = expiresSource;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
