
// this data is used when not connected to server

export default {

    users: [
        {
            id: 0,
            login: "user1",
            password: "pass1",
            role: "admin1"
        },
        {
            id: 1,
            login: "user2",
            password: "pass2",
            role: "admin2"
        }
    ],

    customers: [
        {
            id: 0,
            customerName: "Заказчик1",
            cellNumber: "+1111111111",
            city: "Днепр",
            newPostOfficeNumber: "111",
            balance: 0,
            additionalInfo: "Инфо1",
            orders: []
        },
        {
            id: 1,
            customerName: "Заказчик2",
            cellNumber: "+2222222222",
            city: "Киев",
            newPostOfficeNumber: "222",
            balance: 1000,
            additionalInfo: "Инфо2",
            orders: []
        },
        {
            id: 2,
            customerName: "Заказчик3",
            cellNumber: "+33333333333333",
            city: "Одесса",
            newPostOfficeNumber: "333",
            balance: 333,
            additionalInfo: "Инфо3",
            orders: []
        }
    ]

};

