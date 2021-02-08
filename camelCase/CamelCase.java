package camelCase;

import java.util.ArrayList;
import java.util.List;


public class CamelCase {
	private List<String> list;
	
	public CamelCase() {
		list = new ArrayList<String>(); 
	}

	public List<String> converterCamelCase(String original) {
		//verify invalids
		if(originalStartsWithNumber(original)) {
			throw new NumberStartCamelCaseException("Não é possivel iniciar com número");
		}
		if(isSpecialCharacter(original)) {
			throw new SpecialCharacterCamelCaseException("Não é possivel usar caracteres especiais");
		}
		
		treatFullString(original, false);
		return list;
	}
	private boolean originalStartsWithNumber(String original)  {
		return isNumber(original.charAt(0));
	}
	
	private void treatFullString(String original, boolean recursion) {
		
		String rest = original;
		boolean lastRecursion = true;
		
		for (int i = 1; i < rest.length(); i++) {
			
			if ( isBreakPoint(rest,i) ) {
				lastRecursion = false;
				rest = split(rest, i);
				treatFullString(rest, true);
				break;
			}			
			
		}
		if (lastRecursion) {
			list.add( convertCase(rest) );
		}
		if (recursion) {
			return;
		}
		
	}
	
	private String split(String rest, int position) {
		list.add( convertCase( rest.substring( 0 , position ) ) );
		return rest.substring(position);
	}

	private boolean isBreakPoint(String rest, int i) {
		boolean foundCondition = isBreakCondition(rest.charAt(i));
		if (foundCondition) {
			//verify last one
			if (i+1 == rest.length()) {
				//verify if is alone
				if (i == 0) {
					return true;
				}
				return false;
			}
			//verify all chain of upper or number
			if(isBreakCondition(rest.charAt(0)) && isBreakCondition(rest.charAt(i+1))) {
				return false;
			}
			return true;
		}
		return false;
	}
	private boolean isBreakCondition(char c) {
		return (isUpper(c) || isNumber(c));
	}
	private boolean isUpper(char c) {
		return Character.isUpperCase(c);
	}
	private boolean isNumber(char c) {
		return Character.isDigit(c);
	}
	private boolean isSpecialCharacter(String original) {
		for (int i = 0; i < original.length(); i++) {
			if ( String.valueOf(original.charAt(i)).matches("[^A-Za-z0-9]") ) {
				return true;
			}			
		}
		return false;
	}
	
	private String convertCase(String rest) {
		if (allUpper(rest)) {
			return rest;
		}
		return rest.toLowerCase();
	}
	
	private boolean allUpper(String rest) {
		for (int i = 0; i < rest.length(); i++) {
			if ( ! isUpper(rest.charAt(i)) ) {
				return false;
			}			
		}
		return true;
		
	}
}
