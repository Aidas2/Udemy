// BUDGET CONTROLLER
var budgetController = (function() {

    var Expense = function(id, description, value) {
        this.id = id;
        this.description = description;
        this.value = value;
    };

    var Income = function(id, description, value) {
        this.id = id;
        this.description = description;
        this.value = value;
    };
    
    var data = {            //objects in object :)
        allItems: {
            exp: [],
            inc: []
        },
        totals: {
            exp: 0,
            inc: 0
        }
    }

    return {
        addItem: function(type, des, val) {
            var newItem, ID;

            ID = 0;

            if (type === 'exp') {
                newItem = new Expense(ID, des, val);
            } else if (type === 'inc') {
                newItem = new Income(ID, des, val);
            }
            
        }
    }


})();

// UI CONTROLLER
var UIController = (function() {

    var DOMstrings = {
        inputType: '.add__type',
        inputDescription: '.add__description',
        inputValue: '.add__value',
        inputBtn: '.add__btn',
    }; 

    return {
        getinput: function() {
            return {
            type: document.querySelector(DOMstrings.inputType).value, // inc ir ex
            description: document.querySelector(DOMstrings.inputDescription).value,
            value: document.querySelector(DOMstrings.inputValue).value
            };
        },

        getDOMstrings: function() {
            return DOMstrings;
        }
    };

})();

// GLOBAL APP CONTROLLER
var controller = (function(bdgCtrl, UICtrl){

    var setupEventListeners = function() {

        var DOM = UICtrl.getDOMstrings();
        document.querySelector(DOM.inputBtn).addEventListener('click', ctrlAddItem);

        document.addEventListener('keypress', function(event){
            //console.log(event);
            if(event.keyCode === 13 || event.which === 13) {
                //console.log("Key ENTER was pressed");
                ctrlAddItem();
            }       
        });
    
    }


    var ctrlAddItem = function() {

        var input = UICtrl.getinput();
        //console.log(input);

        //1. Get the field input data

        //2. Add the item to the budget controller;

        //3. Ad new item to the UI

        //4. calculate the budget

        //5. Display the budget on the UI

    };

    return {
        init: function() {
            console.log('Application has started.')
            setupEventListeners();
        }
    }

    

})(budgetController, UIController);

controller.init();