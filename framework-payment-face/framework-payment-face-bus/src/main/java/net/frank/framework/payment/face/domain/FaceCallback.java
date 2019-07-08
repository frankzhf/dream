package net.frank.framework.payment.face.domain;

public interface FaceCallback {
	
	public void onSuccess();

    public void onFailure();

    public void onUnknown();

    public void onDefault();
}