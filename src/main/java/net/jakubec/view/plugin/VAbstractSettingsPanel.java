package net.jakubec.view.plugin;

import javax.swing.Icon;
import javax.swing.JPanel;

public abstract class VAbstractSettingsPanel extends JPanel{
	
	/**
	 * This method is called when the SettingsDialog is created
	 * Here all the GUI components of this Panel should be created
	 */
	public abstract void onSetup();
	/**
	 * Is called when Okey is pressed
	 * Everything which should be stored should happen here
	 */
	public abstract void onOkey();
	/**
	 * returns the Title of this SettingsTab.
	 * if null or "" is returned the tab is not displayed in the SettingsDialog
	 * @return the title of this Panel 
	 */
	public abstract String getTitle();
	/** 
	 * return the Icon of this tab or null if no icon is wanted
	 * @return the icon of the Tab
	 */
	public abstract Icon getIcon();
	
	public abstract String getInfoText();
	
}