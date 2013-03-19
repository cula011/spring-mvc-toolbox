package org.cula011.spring.mvc.controller;

import org.cula011.spring.mvc.constants.ViewConstants;
import org.cula011.spring.mvc.model.SandpitData;
import org.cula011.spring.mvc.model.SandpitDataCollection;
import org.cula011.spring.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/" + ViewConstants.VIEW_SANDPIT_LINK)
public class SandpitController 
{
	private List<User> userList = new ArrayList<User>();

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView displaySandpitForm(ModelMap modelMap)
	{
		SandpitDataCollection sandpitDataCollection = buildFormData();
		modelMap.addAttribute("sandpitFormData", sandpitDataCollection);
		ModelAndView mav = new ModelAndView(ViewConstants.VIEW_SANDPIT, modelMap);
		return mav;
	}

	private SandpitDataCollection buildFormData() {
		List<SandpitData> sandpitDataList = new ArrayList<SandpitData>();
		SandpitData sandpitDataOne = new SandpitData();
		sandpitDataOne.setAccountName("Account One");
		sandpitDataOne.setAccountId(1L);
		sandpitDataOne.setDirectDebit(false);
		sandpitDataList.add(sandpitDataOne);
		SandpitData sandpitDataTwo = new SandpitData();
		sandpitDataTwo.setAccountName("Account Two");
		sandpitDataTwo.setAccountId(2L);
		sandpitDataTwo.setDirectDebit(true);
		sandpitDataList.add(sandpitDataTwo);
		SandpitDataCollection sandpitDataCollection = new SandpitDataCollection();
		sandpitDataCollection.setSandpitDataSet(sandpitDataList);
		return sandpitDataCollection;
	}
	
	
	//@RequestMapping(method = RequestMethod.POST)
	public void submitSandpitForm(@ModelAttribute("sandpitFormData") SandpitDataCollection sandpitDataCollection, BindingResult result) 
	{
		for(SandpitData sandpitData : sandpitDataCollection.getSandpitDataSet())
		{
			String accountName = sandpitData.getAccountName();
			Long accountId = sandpitData.getAccountId();
			boolean directDebit = sandpitData.getDirectDebit();
			System.out.println(String.format("Account: %s, ID: %s, Direct Debit: %s", accountName, accountId, directDebit));
		}
	}
	
    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody String addUser(@ModelAttribute(value="user") User user, BindingResult result)
    {
        String returnText;
        if( !result.hasErrors() )
        {
            userList.add(user);
            returnText = "User has been added to the list. Total number of users are " + userList.size();
        } else
        {
            returnText = "Sorry, an error has occur. User has not been added to list.";
        }
        return returnText;
    }	
}