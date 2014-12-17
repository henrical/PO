package poof.textui.main;

import ist.po.ui.ValidityPredicate;

import poof.core.SessionManager;

public class ValidateCommand extends ValidityPredicate<SessionManager>{
      public ValidateCommand(SessionManager receiver)
      {
	super(receiver);
      }

      public boolean isValid()
      {
	return _receiver.isLoggedIn();
      }
}