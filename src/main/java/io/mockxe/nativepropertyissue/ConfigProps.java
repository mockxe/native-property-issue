package io.mockxe.nativepropertyissue;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.MediaType;

@ConfigurationProperties(value = "foo")
public class ConfigProps{

    private MediaType mediaType;

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

}
