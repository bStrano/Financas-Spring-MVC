/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var selectCategories = document.getElementById("categories");
var options = selectCategories.options;
var selectedCategories = [];
selectCategories.addEventListener("change", function () {
    for (var i = 0; i < options.length; i++) {
        if (options[i].selected) {
            var contains;
            if (selectedCategories.length === 0) {
                selectedCategories.push(options[i].value);
                createSelectedCategoriesPanel();
                createSelectedCategorySpan(options[i].text, options[i].value);
            } else {
                for (var k = 0; k < selectedCategories.length; k++) {
                    if (selectedCategories[k].toString() === (options[i].value)) {
                        contains = true;
                        break;
                    } else {
                        contains = false;
                    }
                }
                if (contains === false) {
                    selectedCategories.push(options[i].value);
                    createSelectedCategorySpan(options[i].text, options[i].value);
                }
            }
        }
    }
    console.log(selectedCategories);
});

function createSelectedCategoriesPanel() {
    // Panel
    var selectedCategoriesPanel = document.createElement("div");
    selectedCategoriesPanel.setAttribute("id", "selectedCategoriesPanel");
    selectedCategoriesPanel.setAttribute("class", "panel panel-info");
    selectedCategoriesPanel.setAttribute("style", "margin-top: 5px");
    document.getElementById("categoryForm").appendChild(selectedCategoriesPanel);
    // Panel Heading
    var selectedCategoriesPanelHead = document.createElement("div");
    selectedCategoriesPanelHead.setAttribute("id", "selectedCategoriesPanelHead");
    selectedCategoriesPanelHead.setAttribute("class", "panel-heading");
    selectedCategoriesPanel.appendChild(selectedCategoriesPanelHead);
    console.log("HEAD");
    console.log(selectedCategoriesPanelHead);
    // Panel Head Title
    var panelTitle = document.createElement("h5");
    panelTitle.setAttribute("class", "panel-title");
    panelTitle.appendChild(document.createTextNode("Categorias selecionadas"));
    selectedCategoriesPanelHead.appendChild(panelTitle);
    // Panel Body
    var selectedCategoriesPanelBody = document.createElement("div");
    selectedCategoriesPanelBody.setAttribute("id", "selectedCategoriesPanelBody");
    selectedCategoriesPanelBody.setAttribute("class", "panel-body");
    selectedCategoriesPanel.appendChild(selectedCategoriesPanelBody);
        console.log(selectedCategoriesPanel);
}

function createSelectedCategorySpan(categoryName, categoryId) {
    var selectedCategoriesPanelBody = document.getElementById("selectedCategoriesPanelBody");
    var span = document.createElement("span");
    span.setAttribute("class", "label label-info");
    span.setAttribute("style", "margin-right: 5px; padding: 7px; font-size: 110%");
    span.setAttribute("id", categoryId +"Span");
    span.appendChild(document.createTextNode(categoryName + "    "));
    // Span to remove
    var removeCategory = document.createElement("span");
    removeCategory.setAttribute("class","glyphicon glyphicon-remove");
    removeCategory.setAttribute("style", "background-color: red");
    removeCategory.setAttribute("id", categoryId + "Remove");
    removeCategory.addEventListener("click", function(){
        removeSelectedCategorySpan(categoryId);
        
    });
    span.appendChild(removeCategory);
    
    selectedCategoriesPanelBody.appendChild(span);
}

function removeSelectedCategorySpan(categoryId){
    var span = document.getElementById(categoryId+"Span");
    console.log(span);
    console.log(categoryId);
    var index = selectedCategories.indexOf(categoryId);
    console.log(index);
    console.log(selectedCategories);
    selectedCategories.splice(index,1);
    console.log(selectedCategories);
    span.outerHTML = "";
}