var _PANEL_PREFFIX = 'panel_';
var _PANEL_TITLEBAR_PREFFIX = 'panel_titlebar_';
var _PANEL_TITLE_PREFFIX = 'panel_title_';
var _PANEL_TITLEBAR_ICON_RESTORE_PREFFIX = 'panel_titlebar_icon_restore_';
var _PANEL_TITLEBAR_ICON_CLOSE_PREFFIX = 'panel_titlebar_icon_close_';
var _PANEL_CONTENT_PREFFIX = 'panel_content_';
var _PANEL_FOOTER_PREFFIX = 'panel_footer_';

var _PANEL_OPERATION_EXPAND_ICON = WEB_ROOT +'/global/images/expand.gif';
var _PANEL_OPERATION_COLLAPSE_ICON = WEB_ROOT +'/global/images/collapse.gif';
var _PANEL_OPERATION_CLOSE_ICON = WEB_ROOT +'/global/images/close.gif';
function expandCollapsePanel(panelId){
	var _panelControlImgId = (_PANEL_TITLEBAR_ICON_RESTORE_PREFFIX+"img_"+panelId);
	var _panelIdContentId= (_PANEL_CONTENT_PREFFIX+panelId);
	if('none'==document.getElementById(_panelIdContentId).style.display){
		document.getElementById(_panelIdContentId).style.display = 'block';
		document.getElementById(_panelControlImgId).src = _PANEL_OPERATION_COLLAPSE_ICON;
	}else{
		document.getElementById(_panelIdContentId).style.display = 'none';
		document.getElementById(_panelControlImgId).src = _PANEL_OPERATION_EXPAND_ICON;
	}
}