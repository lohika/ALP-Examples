package com.lohika.alp.sanity.blocks.flex;

import com.lohika.alp.flexpilot.FindBy;
import com.lohika.alp.flexpilot.FlexElement;
import com.lohika.alp.selenium.log.LogDescription;


public class ButtonTab {

	@LogDescription(name = "Name", type = "edit")
	@FindBy(chain = "id:nameTxt")
    public FlexElement txtName;

	@LogDescription(name = "Standard", type = "button")
	@FindBy(chain = "id:standardBtn")
    public FlexElement btnStandard;

}
