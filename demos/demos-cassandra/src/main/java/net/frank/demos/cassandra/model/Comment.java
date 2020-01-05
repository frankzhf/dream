package net.frank.demos.cassandra.model;

import org.safehaus.uuid.UUID;

public class Comment {
    public static final String KEY_SPACE = "CassSeller";
    public static final String COLUMN_FAMILY = "Comment";

    private UUID uuid;

    private String content;

    private String commentUserName;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String comentUserName) {
        this.commentUserName = comentUserName;
    }
}
