package net.frank.cms.common;

import net.frank.commons.CommonConstants;

public abstract interface CmsCommonConstants extends CommonConstants
{
  public static abstract interface HTML_DEF
  {
    public static final String SPACE = "&nbsp;";
    public static final String READONLY_VALUE = "readonly";
    public static final String BUTTON_DEFAULT_LABEL = "...";

    public static abstract interface INPUT_TYPE
    {
      public static final String TEXT = "text";
      public static final String BUTTON = "button";
    }
  }

  public static abstract interface CHECK_PERMISSION
  {
    public static final String REQUEST_ATTRIBLE_KEY = "checkPermission";
    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";
  }

  public static abstract interface PAGE_MODE
  {
    public static final String EDIT = "edit";
    public static final String VIEW = "view";
  }

  public static abstract interface FORWARD
  {
    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";
  }
}

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.common.CmsCommonConstants
 * JD-Core Version:    0.6.0
 */