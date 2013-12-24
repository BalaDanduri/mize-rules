package com.mize.domain.product;

public class ProductRegisterSupport extends ProductRegister {

	
	private static final long serialVersionUID = 8082422642039343847L;
	
	private String exportedFileUrl;

	public String getExportedFileUrl() {
		return exportedFileUrl;
	}

	public void setExportedFileUrl(String exportedFileUrl) {
		this.exportedFileUrl = exportedFileUrl;
	}

	@Override
	public String toString() {
		return "ProductRegisterSupport [exportedFileUrl=" + exportedFileUrl
				+ "]";
	}
	
}
