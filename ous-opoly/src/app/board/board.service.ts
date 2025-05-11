import { Injectable } from "@angular/core";

@Injectable({providedIn: 'root'})
export class BoardService {

    public currAbrev: string = 'CC';
    public currName: string = 'Chester Coin';

    public tiles = [
        {
            id : 1,
            name: 'GO',
            style:'grid-column: 1 / 2; grid-row: 1 / 2;',
            class: 'corner',
            price: 0.0,
            propInfo: {}
        },
        {
            id : 2,
            name: 'Zesties',
            style:'grid-column: 2 / 3; grid-row: 1 / 2;',
            class: 'property brown',
            price: 60.0,
            propInfo: {
                build: 50.0,
                rent: 2.0,
                house1: 10.0,
                house2: 30.0,
                house3: 90.0,
                house4: 160.0,
                hotel: 250.0
            }
        },
        {
            id : 3,
            name: 'Community Chest',
            style:'grid-column: 3 / 4; grid-row: 1 / 2;',
            class: 'community-chest',
            price: 0.0,
            propInfo: {}
        },
        {
            id : 4,
            name: 'Jimmy\'s',
            style:'grid-column: 4 / 5; grid-row: 1 / 2;',
            class: 'property brown',
            price: 60.0,
            propInfo: {
                build: 50.0,
                rent: 4.0,
                house1: 20.0,
                house2: 60.0,
                house3: 180.0,
                house4: 320.0,
                hotel: 450.0
            }
        },
        {
            id : 5,
            name: 'Fanum Tax',
            style:'grid-column: 5 / 6; grid-row: 1 / 2;',
            class: 'tax',
            price: 200.0,
            propInfo: {
                type: 'Fixed'
            }
        },
        {
            id : 6,
            name: 'N1',
            style:'grid-column: 6 / 7; grid-row: 1 / 2;',
            class: 'property railroad',
            price: 200.0,
            propInfo: {
                road1: 25.0,
                road2: 50.0,
                road3: 100.0,
                road4: 200.0
            }
        },
        {
            id : 7,
            name: 'PMB',
            style:'grid-column: 7 / 8; grid-row: 1 / 2;',
            class: 'property light-blue',
            price: 100.0,
            propInfo: {
                build: 50.0,
                rent: 6.0,
                house1: 30.0,
                house2: 90.0,
                house3: 270.0,
                house4: 400.0,
                hotel: 550.0
            }
        },
        {
            id : 8,
            name: 'Chance',
            style:'grid-column: 8 / 9; grid-row: 1 / 2;',
            class: 'chance',
            price: 0.0,
            propInfo: {}
        },
        {
            id : 9,
            name: 'Joburg',
            style:'grid-column: 9 / 10; grid-row: 1 / 2;',
            class: 'property light-blue',
            price: 100.0,
            propInfo: {
                build: 50.0,
                rent: 6.0,
                house1: 30.0,
                house2: 90.0,
                house3: 270.0,
                house4: 400.0,
                hotel: 550.0
            }
        },
        {
            id : 10,
            name: 'Cape Town',
            style:'grid-column: 10 / 11; grid-row: 1 / 2;',
            class: 'property light-blue',
            price: 120.0,
            propInfo: {
                build: 50.0,
                rent: 8.0,
                house1: 40.0,
                house2: 100.0,
                house3: 300.0,
                house4: 450.0,
                hotel: 600.0
            }
        },
        {
            id : 11,
            name: 'Pozi',
            style:'grid-column: 11 / 12; grid-row: 1 / 2;',
            class: 'corner',
            price: 0.0,
            propInfo: {}
        },
        {
            id : 12,
            name: 'WSS',
            style:'grid-column: 11 / 12; grid-row: 2 / 3;',
            class: 'property pink',
            price: 140.0,
            propInfo: {
                build: 100.0,
                rent: 10.0,
                house1: 50.0,
                house2: 150.0,
                house3: 450.0,
                house4: 625.0,
                hotel: 750.0
            }
        },
        {
            id : 13,
            name: 'Eskom',
            style:'grid-column: 11 / 12; grid-row: 3 / 4;',
            class: 'property utility',
            price: 150.0,
            propInfo: {
                util1: 4,
                util2: 10
            }
        },
        {
            id : 14,
            name: 'CLM',
            style:'grid-column: 11 / 12; grid-row: 4 / 5;',
            class: 'property pink',
            price: 140.0,
            propInfo: {
                build: 100.0,
                rent: 10.0,
                house1: 50.0,
                house2: 150.0,
                house3: 450.0,
                house4: 625.0,
                hotel: 750.0
            }
        },
        {
            id : 15,
            name: 'MPT',
            style:'grid-column: 11 / 12; grid-row: 5 / 6;',
            class: 'property pink',
            price: 160.0,
            propInfo: {
                build: 100.0,
                rent: 12.0,
                house1: 60.0,
                house2: 180.0,
                house3: 500.0,
                house4: 700.0,
                hotel: 900.0
            }
        },
        {
            id : 16,
            name: 'N2',
            style:'grid-column: 11 / 12; grid-row: 6 / 7;',
            class: 'property railroad',
            price: 200.0,
            propInfo: {
                road1: 25.0,
                road2: 50.0,
                road3: 100.0,
                road4: 200.0
            }
        },
        {
            id : 17,
            name: '17',
            style:'grid-column: 11 / 12; grid-row: 7 / 8;',
            class: 'corner',
            price: 0.0,
            propInfo: {}
        },
        {
            id : 18,
            name: 'Community Chest',
            style:'grid-column: 11 / 12; grid-row: 8 / 9;',
            class: 'community-chest',
            price: 0.0,
            propInfo: {}
        },
        {
            id : 19,
            name: '19',
            style:'grid-column: 11 / 12; grid-row: 9 / 10;',
            class: 'corner',
            price: 0.0,
            propInfo: {}
        },
        {
            id : 20,
            name: '20',
            style:'grid-column: 11 / 12; grid-row: 10 / 11;',
            class: 'corner',
            price: 0.0,
            propInfo: {}
        },
        {
            id : 21,
            name: 'Vacation',
            style:'grid-column: 11 / 12; grid-row: 11 / 12;',
            class: 'corner',
            price: 0.0,
            propInfo: {}
        },
        {
            id : 22,
            name: 'New York',
            style:'grid-column: 10 / 11; grid-row: 11 / 12;',
            class: 'property red',
            price: 220.0,
            propInfo: {
                build: 150.0,
                rent: 18.0,
                house1: 90.0,
                house2: 250.0,
                house3: 700.0,
                house4: 875.0,
                hotel: 1050.0
            }
        },
        {
            id : 23,
            name: 'Chance',
            style:'grid-column: 9 / 10; grid-row: 11 / 12;',
            class: 'chance',
            price: 0.0,
            propInfo: {}
        },
        {
            id : 24,
            name: 'Los Angeles',
            style:'grid-column: 8 / 9; grid-row: 11 / 12;',
            class: 'property red',
            price: 220.0,
            propInfo: {
                build: 150.0,
                rent: 18.0,
                house1: 90.0,
                house2: 250.0,
                house3: 700.0,
                house4: 875.0,
                hotel: 1050.0
            }
        },
        {
            id : 25,
            name: 'Miami',
            style:'grid-column: 7 / 8; grid-row: 11 / 12;',
            class: 'property red',
            price: 240.0,
            propInfo: {
                build: 150.0,
                rent: 20.0,
                house1: 100.0,
                house2: 300.0,
                house3: 750.0,
                house4: 925.0,
                hotel: 1100.0
            }
        },
        {
            id : 26,
            name: 'N3',
            style:'grid-column: 6 / 7; grid-row: 11 / 12;',
            class: 'property railroad',
            price: 200.0,
            propInfo: {
                road1: 25.0,
                road2: 50.0,
                road3: 100.0,
                road4: 200.0
            }
        },
        {
            id : 27,
            name: 'Stekistan',
            style:'grid-column: 5 / 6; grid-row: 11 / 12;',
            class: 'property yellow',
            price: 260.0,
            propInfo: {
                build: 150.0,
                rent: 22.0,
                house1: 110.0,
                house2: 330.0,
                house3: 800.0,
                house4: 975.0,
                hotel: 1150.0
            }
        },
        {
            id : 28,
            name: 'Rizzo\'s Lair',
            style:'grid-column: 4 / 5; grid-row: 11 / 12;',
            class: 'property yellow',
            price: 260.0,
            propInfo: {
                build: 150.0,
                rent: 22.0,
                house1: 110.0,
                house2: 330.0,
                house3: 800.0,
                house4: 975.0,
                hotel: 1150.0
            }
        },
        {
            id : 29,
            name: 'Water Works',
            style:'grid-column: 3 / 4; grid-row: 11 / 12;',
            class: 'property utility',
            price: 150.0,
            propInfo: {
                util1: 4,
                util2: 10
            }
        },
        {
            id : 30,
            name: 'Dons Incorporated',
            style:'grid-column: 2 / 3; grid-row: 11 / 12;',
            class: 'property yellow',
            price: 280.0,
            propInfo: {
                build: 150.0,
                rent: 24.0,
                house1: 120.0,
                house2: 360.0,
                house3: 850.0,
                house4: 1025.0,
                hotel: 1200.0
            }
        },
        {
            id : 31,
            name: 'Vy Pozi',
            style:'grid-column: 1 / 2; grid-row: 11 / 12;',
            class: 'corner',
            price: 0.0,
            propInfo: {}
        },
        {
            id : 32,
            name: 'Gold Reef\n(Non halaal)',
            style:'grid-column: 1 / 2; grid-row: 10 / 11;',
            class: 'property green',
            price: 300.0,
            propInfo: {
                build: 200.0,
                rent: 26.0,
                house1: 130.0,
                house2: 390.0,
                house3: 900.0,
                house4: 1100.0,
                hotel: 1275.0
            }
        },
        {
            id : 33,
            name: 'Montecasino\n(Non halaal)',
            style:'grid-column: 1 / 2; grid-row: 9 / 10;',
            class: 'property green',
            price: 300.0,
            propInfo: {
                build: 200.0,
                rent: 26.0,
                house1: 130.0,
                house2: 390.0,
                house3: 900.0,
                house4: 1100.0,
                hotel: 1275.0
            }
        },
        {
            id : 34,
            name: 'Community Chest',
            style:'grid-column: 1 / 2; grid-row: 8 / 9;',
            class: 'community-chest',
            price: 0.0,
            propInfo: {}
        },
        {
            id : 35,
            name: 'Grandwest\n(Non halaal)',
            style:'grid-column: 1 / 2; grid-row: 7 / 8;',
            class: 'property green',
            price: 320.0,
            propInfo: {
                build: 200.0,
                rent: 28.0,
                house1: 150.0,
                house2: 450.0,
                house3: 1000.0,
                house4: 1200.0,
                hotel: 1400.0
            }
        },
        {
            id : 36,
            name: 'M1',
            style:'grid-column: 1 / 2; grid-row: 6 / 7;',
            class: 'property railroad',
            price: 200.0,
            propInfo: {
                road1: 25.0,
                road2: 50.0,
                road3: 100.0,
                road4: 200.0
            }
        },
        {
            id : 37,
            name: 'Chance',
            style:'grid-column: 1 / 2; grid-row: 5 / 6;',
            class: 'chance',
            price: 0.0,
            propInfo: {}
        },
        {
            id : 38,
            name: 'Havoc Hotel',
            style:'grid-column: 1 / 2; grid-row: 4 / 5;',
            class: 'property dark-blue',
            price: 350.0,
            propInfo: {
                build: 200.0,
                rent: 35.0,
                house1: 175.0,
                house2: 500.0,
                house3: 1100.0,
                house4: 1300.0,
                hotel: 1500.0
            }
        },
        {
            id : 39,
            name: 'Income Tax',
            style:'grid-column: 1 / 2; grid-row: 3 / 4;',
            class: 'tax',
            price: 10.0,
            propInfo: {
                type: 'percent'
            }
        },
        {
            id : 40,
            name: 'Bios Trio\'s City',
            style:'grid-column: 1 / 2; grid-row: 2 / 3;',
            class: 'property dark-blue',
            price: 400.0,
            propInfo: {
                build: 200.0,
                rent: 50.0,
                house1: 200.0,
                house2: 600.0,
                house3: 1400.0,
                house4: 1700.0,
                hotel: 2000.0
            }
        }
    ];

}