package testingil.unittesting.examples.mycharacterization;

public class CalculatorDisplay {
    String display = "";
    int lastArgument = 0;
    int result = 0;
    Boolean isError = false;
    Boolean newArgument = false;
    Boolean shouldReset = true;
    ExternalDisplay externalDisplay;
    OperationType lastOperation;

    public CalculatorDisplay(ExternalDisplay externalDisplay){
        this.externalDisplay = externalDisplay;
    }

    public void press(String key) {
        if(key.equals("C")){
            display = "";
            isError = false;
            return;
        }
        if (key.equals("+")) {
            setOpType(OperationType.Plus);
        } else {
            if (key.equals("/")) {
                setOpType(OperationType.Div);
            } else if (key.equals("*")){
                setOpType(OperationType.Mul);
            } else if(key.equals("-")){
                setOpType(OperationType.Minus);
            }
            else if (key.equals("=")) {
                int currentArgument = 0;
                try {
                    if (display.length() >= 1){
                        currentArgument = Integer.parseInt(display);
                    }
                    if (lastOperation == OperationType.Plus) {
                        display = Integer.toString(lastArgument + currentArgument);
                    } else if (lastOperation == OperationType.Div && currentArgument == 0) {
                        display = "Division By Zero Error";
                        isError = true;
                    } else if (lastOperation == OperationType.Div){
                        display = Integer.toString(lastArgument/currentArgument);
                    }  else if (lastOperation ==OperationType.Mul){
                        display = Integer.toString(lastArgument*currentArgument);
                    } else if (lastOperation == OperationType.Minus){
                        display = Integer.toString(lastArgument-currentArgument);
                    }
                } catch (NumberFormatException e){
                    isError = true;
                }

                shouldReset = true;
            } else {
                if (shouldReset) {
                    display = "";
                    shouldReset = false;
                }
                if (newArgument) {
                    display = "";
                    newArgument = false;
                }
                char ch = key.toCharArray()[0];
                if (ch >= '0' && ch <= '9'){
                    display += key;
                }
            }
        }
    }

    public String getDisplay() {
        if (display.equals(""))
            return "0";
        if (isError)
            return "E";
        if (display.length() > 1){
            int pos = 0;
            for (int i = 0; i < display.length(); i++){
                if(display.charAt(i) == '0'){
                    pos++;
                } else break;
            }
            if(pos >= display.length()){
                return "0";
            } else {
                display = display.substring(pos);
            }
        }
        return display;
    }

    void setOpType(OperationType opType){
        if(lastOperation == null){
            if(!display.equals("")){
                this.lastOperation = opType;
                try {
                    lastArgument = Integer.parseInt(display);
                } catch (NumberFormatException e){
                    isError = true;
                }
                shouldReset = true;
            }
        } else {
            try {
                Integer currentArgument = Integer.parseInt(display);
                switch (lastOperation){
                    case Plus:
                        result = lastArgument + currentArgument;
                        break;
                    case Minus:
                        result = lastArgument - currentArgument;
                        break;
                    case Mul:
                        result = lastArgument * currentArgument;
                        break;
                    case Div:
                        if (currentArgument == 0){
                            isError = true;
                        } else {
                            result = lastArgument/currentArgument;
                        }
                        break;
                }
                lastArgument = result;
                display = String.valueOf(lastArgument);
                lastOperation = opType;
            } catch (NumberFormatException e){
                isError = true;
            }
        }
        newArgument = true;
    }
    public void showOtherDisplay(){
        if (externalDisplay.isOn()){
            externalDisplay.show(getDisplay());
        }
    }
}
