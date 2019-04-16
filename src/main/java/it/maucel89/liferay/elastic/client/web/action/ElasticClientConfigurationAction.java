/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package it.maucel89.liferay.elastic.client.web.action;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import it.maucel89.liferay.elastic.client.web.ElasticClientPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.ServletContext;

/**
 * @author Mauro Celani
 */
@Component(
	property = "javax.portlet.name=" + ElasticClientPortletKeys.ELASTIC_CLIENT,
	service = ConfigurationAction.class
)
public class ElasticClientConfigurationAction
	extends DefaultConfigurationAction {

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=it.maucel89.liferay.elastic.client.web)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

}