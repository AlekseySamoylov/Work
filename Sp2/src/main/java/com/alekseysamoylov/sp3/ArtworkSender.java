package com.alekseysamoylov.sp3;

/**
 * Created by alekseysamoylov on 3/8/16.
 */
public interface ArtworkSender {
    void sendArtwork(String artworkPath, Recipient recipient);
    String getFriendlyName();
    String getShortName();
}
