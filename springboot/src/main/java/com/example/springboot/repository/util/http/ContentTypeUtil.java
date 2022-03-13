package com.example.springboot.repository.util.http;


/**
 * 文件类型contentType操作类
 * @author 86183
 */
public class ContentTypeUtil {
    /**
     * 根据文件类型 设置不同的contentType
     * @param returnFileName 文件名
     * @return contentType
     */
    public static String setContentType(String returnFileName) {
        String contentType = "application/octet-stream";
        if ( returnFileName.lastIndexOf(".") < 0) {
            return contentType;
        }
        returnFileName = returnFileName .toLowerCase();
        returnFileName = returnFileName.substring(returnFileName .lastIndexOf("." ) + 1);

        if ("html".equals(returnFileName) || "htm".equals(returnFileName) || "shtml".equals(returnFileName)) {
            contentType = "text/html";
        } else if ("apk".equals(returnFileName)) {
            contentType = "application/vnd.android.package-archive" ;
        } else if ("sis".equals(returnFileName)) {
            contentType = "application/vnd.symbian.install";
        } else if ("sisx".equals(returnFileName)) {
            contentType = "application/vnd.symbian.install";
        } else if ("exe".equals(returnFileName)) {
            contentType = "application/x-msdownload";
        } else if ("msi".equals(returnFileName)) {
            contentType = "application/x-msdownload";
        } else if ("css".equals(returnFileName)) {
            contentType = "text/css";
        } else if ("xml".equals(returnFileName)) {
            contentType = "text/xml";
        } else if ("gif".equals(returnFileName)) {
            contentType = "image/gif";
        } else if ("jpeg".equals(returnFileName) || "jpg".equals(returnFileName)) {
            contentType = "image/jpeg";
        } else if ("js".equals(returnFileName)) {
            contentType = "application/x-javascript";
        } else if ("atom".equals(returnFileName)) {
            contentType = "application/atom+xml";
        } else if ("rss".equals(returnFileName)) {
            contentType = "application/rss+xml";
        } else if ("mml".equals(returnFileName)) {
            contentType = "text/mathml";
        } else if ("txt".equals(returnFileName)) {
            contentType = "text/plain";
        } else if ("jad".equals(returnFileName)) {
            contentType = "text/vnd.sun.j2me.app-descriptor" ;
        } else if ("wml".equals(returnFileName)) {
            contentType = "text/vnd.wap.wml";
        } else if ("htc".equals(returnFileName)) {
            contentType = "text/x-component";
        } else if ("png".equals(returnFileName)) {
            contentType = "image/png";
        } else if ("tif".equals(returnFileName) || "tiff".equals(returnFileName)) {
            contentType = "image/tiff";
        } else if ("wbmp".equals(returnFileName)) {
            contentType = "image/vnd.wap.wbmp";
        } else if ("ico".equals(returnFileName)) {
            contentType = "image/x-icon";
        } else if ("jng".equals(returnFileName)) {
            contentType = "image/x-jng";
        } else if ("bmp".equals(returnFileName)) {
            contentType = "image/x-ms-bmp";
        } else if ("svg".equals(returnFileName)) {
            contentType = "image/svg+xml";
        } else if ("jar".equals(returnFileName) || "var".equals(returnFileName) || "ear".equals(returnFileName)) {
            contentType = "application/java-archive";
        } else if ("doc".equals(returnFileName)) {
            contentType = "application/msword";
        } else if ("pdf".equals(returnFileName)) {
            contentType = "application/pdf";
        } else if ("rtf".equals(returnFileName)) {
            contentType = "application/rtf";
        } else if ("xls".equals(returnFileName)) {
            contentType = "application/vnd.ms-excel";
        } else if ("ppt".equals(returnFileName)) {
            contentType = "application/vnd.ms-powerpoint";
        } else if ("7z".equals(returnFileName)) {
            contentType = "application/x-7z-compressed";
        } else if ("rar".equals(returnFileName)) {
            contentType = "application/x-rar-compressed";
        } else if ("swf".equals(returnFileName)) {
            contentType = "application/x-shockwave-flash";
        } else if ("rpm".equals(returnFileName)) {
            contentType = "application/x-redhat-package-manager" ;
        } else if ("der".equals(returnFileName) || "pem".equals(returnFileName) || "crt".equals(returnFileName)) {
            contentType = "application/x-x509-ca-cert";
        } else if ("xhtml".equals(returnFileName)) {
            contentType = "application/xhtml+xml";
        } else if ("zip".equals(returnFileName)) {
            contentType = "application/zip";
        } else if ("mid".equals(returnFileName) || "midi".equals(returnFileName) || "kar".equals(returnFileName)) {
            contentType = "audio/midi";
        } else if ("mp3".equals(returnFileName)) {
            contentType = "audio/mpeg";
        } else if ("ogg".equals(returnFileName)) {
            contentType = "audio/ogg";
        } else if ("m4a".equals(returnFileName)) {
            contentType = "audio/x-m4a";
        } else if ("ra".equals(returnFileName)) {
            contentType = "audio/x-realaudio";
        } else if ("3gpp".equals(returnFileName) || "3gp".equals(returnFileName)) {
            contentType = "video/3gpp";
        } else if ("mp4".equals(returnFileName)) {
            contentType = "video/mp4";
        } else if ("mpeg".equals(returnFileName) || "mpg".equals(returnFileName)) {
            contentType = "video/mpeg";
        } else if ("mov".equals(returnFileName)) {
            contentType = "video/quicktime";
        } else if ("flv".equals(returnFileName)) {
            contentType = "video/x-flv";
        } else if ("m4v".equals(returnFileName)) {
            contentType = "video/x-m4v";
        } else if ("mng".equals(returnFileName)) {
            contentType = "video/x-mng";
        } else if ("asx".equals(returnFileName) || "asf".equals(returnFileName)) {
            contentType = "video/x-ms-asf";
        } else if ("wmv".equals(returnFileName)) {
            contentType = "video/x-ms-wmv";
        } else if ("avi".equals(returnFileName)) {
            contentType = "video/x-msvideo";
        }else if("xlsx".equals(returnFileName)){
            contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        }else if("docx".equals(returnFileName)){
            contentType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
        }else if("pptx".equals(returnFileName)){
            contentType = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
        }

        return contentType;
    }

}