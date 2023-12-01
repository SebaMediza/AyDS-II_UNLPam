var availableOptions = [
    #foreach($item in $RES)
        { id: $item.getId(), name: $item.getNombre(), category: $item.getNombre().substring(0, 1).toUpperCase(), ordered: false },
    #end
];


function addProduct() {
    // Get selected product details
    var selectedOption = document.getElementById("productSelect").options[document.getElementById("productSelect").selectedIndex];
    var productId = selectedOption.value;
    var productName = selectedOption.text;

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
    productNameCell.innerHTML = '<input type="text" value="' + productName + '" name="products[' + productId + ']" readonly />';
    quantityCell.innerHTML = '<input type="number" value="' + quantity + '" name="products[' + productId + ']" min="1" max="50" />';
    deleteCell.innerHTML = '<button type="button" onclick="deleteProduct(this)"><i class="fas fa-trash-alt"></i></button>';

    // Remove the selected option from the dropdown
    selectedOption.remove();

    // Show the table header if it was hidden
    var tableHead = document.getElementById("productTableHead");
    if (tableHead.style.display === "none") {
        tableHead.style.display = "table-header-group";
    }
}

function deleteProduct(button) {
    // Delete the corresponding row
    var row = button.parentNode.parentNode;
    var productName = row.cells[0].innerHTML;

    // Find the product in the available options array based on the product name
    var product = availableOptions.find(option => option.name === productName);

    if (product) {
        // Mark the product as logically ordered
        product.ordered = true;

        // Remove the row from the table
        row.parentNode.removeChild(row);

        // Hide the table header if there are no rows
        if (document.getElementById("productTable").querySelector('tbody').rows.length === 0) {
            document.getElementById("productTableHead").style.display = "none";
        }

        // Regenerate the content of the select
        regenerateSelect();
    } else {
        console.error('Failed to find product in the available options array.');
    }
}

function regenerateSelect() {
    // Remove all options and categories from the select
    var select = document.getElementById("productSelect");
    select.innerHTML = '';

    // Create a map to group options by category
    var categoryMap = new Map();

    // Sort options alphabetically and group them by category
    availableOptions.sort(function (a, b) {
        return a.name.localeCompare(b.name);
    }).forEach(function (option) {
        if (!categoryMap.has(option.category)) {
            categoryMap.set(option.category, []);
        }
        categoryMap.get(option.category).push(option);
    });

    // Regenerate the options and categories
    categoryMap.forEach(function (options, category) {
        var optgroup = document.createElement("optgroup");
        optgroup.label = category;
        select.appendChild(optgroup);

        options.forEach(function (option) {
            var optionElement = document.createElement("option");
            optionElement.value = option.id;
            optionElement.text = option.name;
            optgroup.appendChild(optionElement);
        });
    });
}