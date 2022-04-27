/*
 * ao-badges - Badges from shields.io bundled into a reusable JSP-based web component.
 * Copyright (C) 2020, 2021, 2022  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of ao-badges.
 *
 * ao-badges is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ao-badges is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ao-badges.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.aoapps.badges;

import com.aoapps.web.resources.registry.Group;
import com.aoapps.web.resources.registry.Style;
import com.aoapps.web.resources.servlet.RegistryEE;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener("Registers the style in RegistryEE.")
public class AoBadgesStyle implements ServletContextListener {

  /**
   * The name of the {@linkplain com.aoapps.web.resources.servlet.RegistryEE.Application application-scope}
   * group that will be used for badges.
   */
  public static final Group.Name RESOURCE_GROUP = new Group.Name("ao-badges");

  public static final Style AO_BADGES_CSS = new Style("/ao-badges/ao-badges.css");

  @Override
  public void contextInitialized(ServletContextEvent event) {
    // Add our CSS files
    RegistryEE.Application.get(event.getServletContext())
        .activate(RESOURCE_GROUP)// TODO: Activate as-needed
        .getGroup(RESOURCE_GROUP)
        .styles
        .add(AO_BADGES_CSS);
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
    // Do nothing
  }
}
