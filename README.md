
# UAS Pemrosesan Data Tersebar

Aplikasi Pembelian dan Penjualan dengan menggunakan database Oracle, System Administrator menggunakan CodeIgniter dan Interface di Mobile Apps (Android). Komunikasi data antar Aplikasi menggunakan *RESTful Service* di oracle.

## Requirements

- [Virtual Box](https://www.virtualbox.org/wiki/Downloads) (Virtual Server)
- [Oracle Developer Day 11g](https://www.oracle.com/technetwork/database/enterprise-edition/databaseappdev-vm-161299.html) (Database)
- [Android Studio](https://developer.android.com/studio) (Android IDE)
- [Codeigniter](https://www.codeigniter.com/) (Framework PHP)

## Tutorial

### Database

Aplikasi ini memiliki 5 table, yaitu :

1. [Customer](#table-customer)
2. [Barang](#table-barang)
3. [Penjualan](#table-penjualan)
4. [Pembelian](#table-pembelian)
5. [Supplier](#table-supplier)

#### Table Customer

![Table Customer!](./gambar/table/table-customer.png "Table Customer")

#### Table Barang

![Table Barang!](./gambar/table/table-barang.png "Table Barang")

#### Table Penjualan

![Table Penjualan!](./gambar/table/table-penjualan.png "Table Penjualan")

#### Table Pembelian

![Table Pembelian!](./gambar/table/table-pembelian.png "Table Pembelian")

#### Table Supplier

![Table Supplier!](./gambar/table/table-supplier.png "Table Supplier")

### *RESTful Services*

![RESTful Services](./gambar/restful-services.png)

PUT dan DELETE menggunakan {id} untuk mengidentifikasi data yang akan dieksekusi.  
Metode HTTP yang digunakan dalam aplikasi ini adalah:

| Method | Description |
| ------ | ------ |
| **GET** | menyediakan hanya akses baca pada _resource_ |
| **POST** | digunakan untuk menciptakan _resource_ baru |
| **PUT** | digunakan untuk memperbarui _resource_ yang ada atau membuat _resource_ baru |
| **DELETE** | digunakan untuk menghapus _resource_ |

*Resource Handler* & *Query* dapat dilihat pada gambar dibawah ini.

#### *RESTful Service* pada Barang

- **GET Barang**  
![GET](./gambar/restful-service/barang/get.png)

- **POST Barang**  
![POST](./gambar/restful-service/barang/post.png)
![POST Paramter](./gambar/restful-service/barang/post-parameters.png)

- **PUT Barang**  
![PUT](./gambar/restful-service/barang/put.png)
![PUT Paramter](./gambar/restful-service/barang/put-parameters.png)

- **DELETE Barang**  
![DELETE](./gambar/restful-service/barang/delete.png)


#### *RESTful Service* pada Customer

- **GET Customer**  
![GET](./gambar/restful-service/customer/get.png)

- **POST Customer**  
![POST](./gambar/restful-service/customer/post.png)
![POST Paramter](./gambar/restful-service/customer/post-parameters.png)

- **PUT Customer**  
![PUT](./gambar/restful-service/customer/put.png)
![PUT Paramter](./gambar/restful-service/customer/put-parameters.png)

- **DELETE Customer**  
![DELETE](./gambar/restful-service/customer/delete.png)

#### *RESTful Service* pada Penjualan

- **GET Penjualan**  
![GET](./gambar/restful-service/penjualan/get.png)

- **POST Penjualan**  
![POST](./gambar/restful-service/penjualan/post.png)
![POST Paramter](./gambar/restful-service/penjualan/post-parameters.png)

#### *RESTful Service* pada Pembelian

- **GET Pembelian**  
![GET](./gambar/restful-service/pembelian/get.png)

- **POST Pembelian**  
![POST](./gambar/restful-service/pembelian/post.png)
![POST Paramter](./gambar/restful-service/pembelian/post-parameters.png)

#### *RESTful Service* pada Supplier

- **GET Supplier**  
![GET](./gambar/restful-service/supplier/get.png)

- **POST Supplier**  
![POST](./gambar/restful-service/supplier/post.png)

- **PUT Supplier**  
![PUT](./gambar/restful-service/supplier/put.png)

- **DELETE Supplier**  
![DELETE](./gambar/restful-service/supplier/delete.png)

### CodeIgniter

[Script](./oracle-uas/application/libraries/Api.php) dibawah ini merupakan script php yang digunakan untuk mengakses *RESTful Services* dari Oracle menggunakan library [Goutte](https://github.com/FriendsOfPHP/Goutte).

```php
use GuzzleHttp\Client;

defined('BASEPATH') or exit('No direct script access allowed');

class Api
{
    private $client;

    public function __construct()
    {
        // base url yang digunakan untuk mengakses RESTful API
        $this->client = new Client(['base_uri' => 'http://192.168.43.75:8888/apex/obe/']);
    }

    public function request($method, $uri, $data = [])
    {
        // data di convert menjadi data JSON
        $options['json'] = $data;

        // jika metode HTTP nya adalah DELETE maka response yang diberikan adalah status code nya
        if ($method == 'delete') {
            $request = $this->client->request($method, $uri);
            return $request->getStatusCode();
        }

        $request = $this->client->request($method, $uri, $options);

        // response yang diberikan berupa content nya
        return $request->getBody()->getContents();
    }
}
```

#### Tampilan Web

- Barang
![List Barang](./gambar/web/barang.png)

- Customer
![List Customer](./gambar/web/customer.png)

- Penjualan
![List Penjualan](./gambar/web/penjualan.png)

- Pembelian
![List Pembelian](./gambar/web/pembelian.png)

- Supplier
![List Supplier](./gambar/web/supplier.png)

### License

Copyright © 2019, [Resi Dwi](https://github.com/residwi).
Released under the [MIT License](LICENSE).
