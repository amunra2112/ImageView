/*
 * Copyright 2018 Michael Jakubec
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.jakubec.view.app;

import net.jakubec.view.plugin.PluginOrganizer;
import net.jakubec.view.plugin.ViewPlugin;
import net.jakubec.view.properties.VProperties;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

class MenuFactory {

	private static void addAcceleration(final JMenuItem item, final char a) {
		item.setAccelerator(KeyStroke.getKeyStroke(a, InputEvent.CTRL_MASK));
	}

	public static JMenuBar createEditMenu(final ActionListener act) {
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu(VProperties.getValue("menu.data"));
		menu.setMnemonic(VProperties.getValue("menu.data").toCharArray()[0]);

		createMenuItem(menu, "menu.data.open", 'O', "open", true, "open.gif", act);
		JMenuItem menuitem = createMenuItem(menu, "menu.data.save_as", 'S', "saveAs", act);
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK
				| InputEvent.SHIFT_MASK));
		createMenuItem(menu, "menu.data.save", 'S', "save", act);
		menu.addSeparator();
		createMenuItem(menu, "menu.data.print", 'P', "print", act);
		menu.addSeparator();
		createMenuItem(menu, "menu.data.dia", 'D', "dia", true, "dia.gif", act);
		menu.addSeparator();
		createMenuItem(menu, "menu.data.exit", '\0', "exit", act);
		menubar.add(menu);

		menu = new JMenu(VProperties.getValue("menu.edit"));
		menu.setMnemonic(VProperties.getValue("menu.edit").toCharArray()[0]);
		createMenuItem(menu, "menu.edit.undo", 'Z', "undo", act);
		menu.addSeparator();
		createMenuItem(menu, "menu.edit.settings", '\0', "settings", act);

		menubar.add(menu);

		menu = new JMenu(VProperties.getValue("menu.nav"));
		menu.setMnemonic(VProperties.getValue("menu.nav").toCharArray()[0]);
		createMenuItem(menu, "menu.nav.next", 'N', "next", act);
		menuitem = createMenuItem(menu, "menu.nav.prev", '0', "previous", act);
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK
				| InputEvent.SHIFT_MASK));
		menubar.add(menu);

		menu = new JMenu(VProperties.getValue("menu.view"));
		menu.setMnemonic(VProperties.getValue("menu.view").toCharArray()[0]);
		createMenuItem(menu, "menu.view.full", 'V', "full", act);
		menu.addSeparator();
		menuitem = createMenuItem(menu, "menu.view.zoomin", '+', "zoom+", true, "zoom+.gif", act);
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS| KeyEvent.VK_ADD, InputEvent.CTRL_MASK));
		menuitem = createMenuItem(menu, "menu.view.zoomout", '-', "zoom-", true, "zoom-.gif", act);
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS| KeyEvent.VK_SUBTRACT, InputEvent.CTRL_MASK));
		createMenuItem(menu, "menu.view.fitin", '0', "zoom0", true, "zoom.gif", act);
		createMenuItem(menu, "menu.view.normalSize", '1', "zoom1", true, "zoom100.gif", act);
		menubar.add(menu);

		menu = new JMenu(VProperties.getValue("menu.image"));
		menu.setMnemonic(VProperties.getValue("menu.image").toCharArray()[0]);
		createMenuItem(menu, "menu.image.clockwise", 'R', "rot+", true, "Rot+.gif", act);


		menuitem = createMenuItem(menu, "menu.image.counter_clockwise", 'R', "rot-", true,
				"Rot-.gif", act);
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK
				| InputEvent.SHIFT_MASK));
		menu.add(menuitem);

		menuitem = new JMenuItem("DrawNew");
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		// addAcceleration(menuitem,'R');
		menuitem.setActionCommand("mike");
		menuitem.addActionListener(act);
		menu.add(menuitem);

		menubar.add(menu);

		menu = new JMenu(VProperties.getValue("menu.plugin"));
		List<ViewPlugin> plugins = PluginOrganizer.getInstance().getPlugins();
		for (ViewPlugin plugin : plugins) {
			menu.add(plugin.getMenu());
		}
		menubar.add(menu);
		return menubar;
	}

	public static JMenuBar createMenu(final ActionListener act) {
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu(VProperties.getValue("menu.data"));
		menu.setMnemonic(VProperties.getValue("menu.data").toCharArray()[0]);

		createMenuItem(menu, "menu.data.open", 'O', "open", true, "open.gif", act);
		JMenuItem menuitem = createMenuItem(menu, "menu.data.save_as", 'S', "saveAs", act);
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK
				| InputEvent.SHIFT_MASK));
		createMenuItem(menu, "menu.data.save", 'S', "save", act);
		menu.addSeparator();
		createMenuItem(menu, "menu.data.print", 'P', "print", act);
		menu.addSeparator();
		createMenuItem(menu, "menu.data.dia", 'D', "dia", true, "dia.gif", act);
		menu.addSeparator();
		createMenuItem(menu, "menu.data.exit", '\0', "exit", act);
		menubar.add(menu);

		menu = new JMenu(VProperties.getValue("menu.edit"));
		menu.setMnemonic(VProperties.getValue("menu.edit").toCharArray()[0]);
		createMenuItem(menu, "menu.edit.settings", '\0', "settings", act);
		menubar.add(menu);

		menu = new JMenu(VProperties.getValue("menu.nav"));
		menu.setMnemonic(VProperties.getValue("menu.nav").toCharArray()[0]);
		createMenuItem(menu, "menu.nav.next", 'N', "next", act);
		menuitem = createMenuItem(menu, "menu.nav.prev", '0', "previous", act);
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK
				| InputEvent.SHIFT_MASK));
		menubar.add(menu);

		menu = new JMenu(VProperties.getValue("menu.view"));
		menu.setMnemonic(VProperties.getValue("menu.view").toCharArray()[0]);
		createMenuItem(menu, "menu.view.full", 'V', "full", act);
		menu.addSeparator();
		menuitem = createMenuItem(menu, "menu.view.zoomin", '+', "zoom+", true, "zoom+.gif", act);
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, InputEvent.CTRL_MASK));
		createMenuItem(menu, "menu.view.zoomout", '-', "zoom-", true, "zoom-.gif", act);
		createMenuItem(menu, "menu.view.fitin", '0', "zoom0", true, "zoom.gif", act);
		createMenuItem(menu, "menu.view.normalSize", '1', "zoom1", true, "zoom100.gif", act);
		menubar.add(menu);

		menu = new JMenu(VProperties.getValue("menu.image"));
		menu.setMnemonic(VProperties.getValue("menu.image").toCharArray()[0]);
		createMenuItem(menu, "menu.image.clockwise", 'R', "rot+", true, "Rot+.gif", act);


		menuitem = createMenuItem(menu, "menu.image.counter_clockwise", 'R', "rot-", true,
				"Rot-.gif", act);
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK
				| InputEvent.SHIFT_MASK));
		menu.add(menuitem);
		menu.addSeparator();
		createMenuItem(menu, "menu.image.delete", '\0', "del", true, "delete.gif", act);
		menu.addSeparator();
		menuitem = new JMenuItem("DrawNew");
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		// addAcceleration(menuitem,'R');
		menuitem.setActionCommand("mike");
		menuitem.addActionListener(act);
		menu.add(menuitem);

		menubar.add(menu);

		/* Plugin Menus inserted */
		menu = new JMenu(VProperties.getValue("menu.plugin"));
//		List<ViewPlugin> plugins = PluginOrganizer.getInstance().getPlugins();
//		for (ViewPlugin plug : plugins) {
//			JMenu pluginMenu = new JMenu(plug.getName());
//			createMenuItem(pluginMenu, "Start", '\0', "plug-" + plug.getName(), act);
//			pluginMenu.add(plug.getMenu());
//			menu.add(pluginMenu);
//		}
		if (menu.getMenuComponentCount() > 0) {
			menubar.add(menu);
		}

		menu = new JMenu(VProperties.getValue("menu.help"));
		menu.setMnemonic(VProperties.getValue("menu.help").toCharArray()[0]);
		createMenuItem(menu, "menu.help.checkUpdate", '\0', "checkUpdate", act);
		menu.addSeparator();
		createMenuItem(menu, "menu.help.about", 'H', "help", act);

		menubar.add(menu);

		return menubar;
	}

	private static JMenuItem createMenuItem(final JMenu menu, final String key, final char acc,
			final String actionCommand, final ActionListener act) {
		return createMenuItem(menu, key, acc, actionCommand, false, null, act);
	}

	private static JMenuItem createMenuItem(final JMenu menu, final String key, final char acc,
			final String actionCommand, final boolean photo, final String path,
			final ActionListener act) {
		JMenuItem menuitem;
		if (photo) {
			menuitem = new JMenuItem(VProperties.getValue(key), new ImageIcon(MenuFactory.class.getResource("/"+path)));
		} else {
			menuitem = new JMenuItem(VProperties.getValue(key));
		}
		if (acc != '\0') {
			addAcceleration(menuitem, acc);
		}
		menuitem.setActionCommand(actionCommand);
		menuitem.addActionListener(act);
		menu.add(menuitem);
		return menuitem;
	}



}
