function addProduct() {
    // Get selected product details
    var selectElement = document.getElementById("productSelect");
    var selectedOption = selectElement.options[selectElement.selectedIndex];
    var productId = selectedOption.value;
    var productName = selectedOption.text;
    var category = productName.substr(0,1);

    // Get the quantity value
    var quantityInput = document.getElementById("quantityInput");
    var quantity = quantityInput.value;

    // Create a new row in the table
    var table = document.getElementById("productTable");
    var tbody = table.querySelector('tbody');
    var newRow = tbody.insertRow();

    // Add cells to the new row
    var productNameCell = newRow.insertCell(0);
    var quantityCell = newRow.insertCell(1);
    var deleteCell = newRow.insertCell(2);

    // Set the content of the cells
    productNameCell.innerHTML = '<input type="text" id_prod='+productId+' value="' + productName + '" name="products['+productId+']" readonly style="border: none;outline: none;;" />';
    quantityCell.innerHTML = '<input type="number" id_prod='+productId+' value="' + quantity + '" name="quantities['+productId+']" min="1" max="50" />';
    deleteCell.innerHTML = '<button type="button" onclick="deleteProduct(this)"><i class="fas fa-trash-alt"></i></button>';

    // Remove the selected option from the dropdown
    selectElement.remove(selectElement.selectedIndex);

    // Show the table header if it was hidden
    var tableHead = document.getElementById("productTableHead");
    if (tableHead.style.display === "none") {
        tableHead.style.display = "table-header-group";
    }

    // Regenerate the content of the select
    sortAndRegenerateSelect();
}

function deleteProduct(button) {
    // Delete the corresponding row
    var row = button.parentNode.parentNode;
    var productName = row.cells[0].querySelector('input').value;
    var productId = row.cells[0].querySelector('input').getAttribute('id_prod');
    var category = productName.substr(0,1)

    // Remove the row from the table
    row.parentNode.removeChild(row);

    // Add the deleted option back to the select
    var select = document.getElementById("productSelect");
    var optionElement = document.createElement("option");
    optionElement.value = productId;
    optionElement.text = productName;
    optionElement.setAttribute('data-category', category);
    select.appendChild(optionElement);

    // Hide the table header if there are no rows
    if (document.getElementById("productTable").querySelector('tbody').rows.length === 0) {
        document.getElementById("productTableHead").style.display = "none";
    }

    // Sort and regenerate the content of the select
    sortAndRegenerateSelect();
}

function sortAndRegenerateSelect() {
    // Remove all options and categories from the select
    var select = document.getElementById("productSelect");

    // Create an array to store options
    var optionsArray = Array.from(select.options);

    // Sort options alphabetically
    optionsArray.sort(function (a, b) {
        return a.text.localeCompare(b.text);
    });

    // Create a set to track unique categories
    var categorySet = new Set();

    // Iterate through the sorted options and recreate the set
    optionsArray.forEach(function (option) {
        categorySet.add(option.text.substr(0,1));
    });

    // Clear the select
    select.innerHTML = '';

    // Regenerate the options and categories
    categorySet.forEach(function (currentCategory) {
        // Filter options based on the current category
        var optionsInCategory = optionsArray.filter(function (option) {
            return option.text.substr(0,1) === currentCategory;
        });

        // Create an optgroup for the current category
        var optgroup = document.createElement("optgroup");
        optgroup.label = currentCategory;
        select.appendChild(optgroup);

        // Append options to the optgroup
        optionsInCategory.forEach(function (option) {
            select.appendChild(option);
        });
    });
}

sortAndRegenerateSelect(); // You may need to pass the initial product details if needed