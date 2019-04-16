<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%@ page import="it.maucel89.liferay.elastic.client.web.ElasticClientConstants" %>
<%@ page import="it.maucel89.liferay.elastic.client.web.action.ExecuteMVCRenderCommand" %>


<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />


<%
String elasticBaseURL = GetterUtil.getString(portletPreferences.getValue(
	"elasticBaseURL", ElasticClientConstants.DEFAULT_ELASTIC_BASE_URL));
%>
