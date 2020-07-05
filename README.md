# KelimeGezmeceOyunu
KELİME GEZMECE OYUNU

1
KELİME GEZMECE OYUNU
170202122-Fatih KARAMAN
Bilgisayar Mühendisliği Bölümü
Kocaeli Üniversitesi
f4t1hkrmn@gmail.com envercalcoban@gmail.com
1. Özet ( Genel Yapı )
Uygulama ilk olarak oyunu oynayacak kullanıcı girişi
tasarlanmıştır. Bu giriş paneli ile kullanıcıdan ad ve mail
adresini girmesi ve ardından giriş butonuna tıklayarak oyun
ara yüzüne geçişi sağlanmıştır. Tabi bu geçiş sırasında
kullanıcı bilgileri veri tabanına kaydediliyor. Oyuna ilk giriş
yapan kullanıcı yeni kayıt oluşturulurken, daha önce kayıtlı
kişi giriş yaptığında veritabanına yeni bir kayıt
oluşturulmadan mevcut bilgiler üzerinden oyuncunun oyuna
girmesi sağlandı. Daha önce kayıt yaparak oyuna girmiş
birinin seviye zorluk ve skor bilgileri mail adresi eşlemesine
göre bulunarak bu şekilde oyuncunun kaldığı yerden devam
edebilmesi sağlanıyor. Oyuncunun haricinde veritabanında
kelime ve kelimelere ait konum bilgilerini alt kelime
bilgilerini seviyelere ve zorluklara göre tutan 3 farklı tablo
daha bulunmaktadır. Bu tablolar sayesinde kullanıcı sütununa
kayıtlı seviye ve zorluk bilgileri alınarak ızgaraya oyun
kelimeler bu şekilde yerleştiriliyor. Kullanıcı giriş yapması ile
oyun paltformu açılır ardından ilk kelime harfleri oyun
arayüzü alt alanında bulunan butonlar üzerine yerleşir. Tabi
burada kelime içerisinde kısıtlı sayıda harf olacak şekilde
kodlanmıştır.oyunun başlamasıyla arka planda bilinen ama
oyuncunun harflerin kombinasyonu ile bulmaya çalıştığı
kelime yavaş yavaş inşa edilmekte ve oyuncu harflere
tıklamasıyla kelime içerisinde bulunan alt kelimeler oyun
ızgarasına yerleşmektedir.oluşan kelimelerden oyuncun son
harfi girmesiyle bölüm tamamlanmış olur. Oyun sırasında
doğru tahmin edilen her kelimeye sistem zamanından çekilen
bilgiye paralel bir kat sayı ile çarpılarak puan
oluşturulmaktadır. Bu puan oyuncunun ilerlemesiyle skor
bilgilerine eklenmekte ve update edilmektedir. Oyunda 3
seviye bulunmakta ve her seviye altında 6 şar alt seviye
bulunmaktadır. Bu alt seviyeler 6 yı tamamlamasıyla oyuncu
seviye atlayarak bir sonraki seviyeye geçmektedir.bu şekilde
3. Sezon 6. Bölüm sonuna kadar ilerleyen oyuncu puanları
biriktirerek skorunu oluşturmakdadır.
2. Giriş
Projede kelime gezmece olarak bilinen oyunun basit bir
versiyonunu gerçekleştirmeniz beklenmektedir. Oyunun
amacı oyunun seviyesine bağlı olarak verilen harfleri
kullanarak ekrana gelen harf bulmacasına uygun kelimeleri
türetmektir. 1. Oyunda üç seviye ve her seviyenin kendi
içerisinde en az altı bulmaca bulunması gerekmektedir.
Seviyelerin zorluklarını kullanılan harf sayısı, alt
seviyelerin zorluklarını ise kullanılan kelime sayısı
belirleyecektir. Birinci seviyede kelimeler üç harf
kullanılarak. İkinci seviyede kelimeler dört harf kullanılarak
Üçüncü seviyede kelimeler beş ve üzeri harf kullanılarak
oluşturulacaktır. 2. Oyunda puan hesabı yapmanız da
beklenmektedir. Puan hesabı yaparken puan ile geçen zaman
ve kullanıcının başarısız denemeleri arasında ters bir orantı
olduğu unutulmamalıdır. Yani işlem süresi ne kadar uzarsa ve
yanlış harf kombinasyonları ne kadar artarsa puan da o kadar
düşük olacaktır. 3. Aynı zamanda her alt seviyeye ait en yüksek
skorun puan ve isim olarak saklanması eklenmektedir.4.
Oyuncuya yardımcı olmak açısından kelime oluşturmak için
kullanılacak harflerin yerlerini değiştirme özelliği de
eklenecektir. Aşağıda oyunun farklı seviyelerine ait ekran
görüntüsü verilmiştir. İlk resim ikinci seviyeye ait ekran
görüntüsünü, ikinci resim ise gerçeklemeniz beklenen üçüncü
seviyeye ait örnek ekran görüntüsünü göstermektedir.
2.1. Temel Bilgiler
Proje gelişiminde;
Android Studio ( java ) ve veritabanı olarak SQLlite
programlama dilleri kullanılmıştır. Geliştirme ortamı
olarak virsual studio kullanılmıştır.
2.2. Problem Tanımı
1). Android studio geliştirice oyun sayfalarının hazır toollar
ile oluşturulmasıda problemler yaşandı.
2). Geliştirilen uygulamanın test işlemleri için kurulan sanal
işleitm başlangıç olarak çalıştırılamadı.
3). Oyunun tasarımanda farklı activityler kullanıldı fakat bu
activityler arası object veri iletimi ilk başta sağlanamadı.
4).Oyunun geliştirilmesinde ilerleme sağlandıkça kodlar
karmaşıklaştığı için hataların tespiti zorlaştı.
5). Geliştirilen oyunun test işlemleri sırasında sanal test cihazı
mobil cihazında anlamsız kapanmalar hatalar oldu.
2.3. Yapılan Araştırmalar
1). Tool kullanımında tasarımda yaşanan problemli
durumlarda ilgili arayüzler ile kodlaranak çözüm sağlandı.
2). Uyumlu ve güncel test uygulaması kurularak çözüm
sağlandı.
3). Yapılan araştırmalarla Intent kütüphanesi kullanarak
activityler arası nesne ve veri gönderimi sağlandı.
4). Android platformda debug ile üzerine eğitici videolar
izlenerek hatalar debug analizi ile çözülme yoluna gidilerek
çözüm sağlandı.2
5). Sanal mobil cihazda hataların oluşması durumunda clear
edilerek çözümler sağlandı.
2.4. Dosya Yapıları ve Fonksiyonlar
Uygulamada kullanılan fonksiyonlar aşağıda
dosyalarıyla birlikte listelenmiştir.
Oyuncu(): Oyuncu sınıfında nesne üretir.
Database() : Database sınıfından yeni
database oluşturmamız için gereklidir.
oyuncuVarmiKontrolEt() : kayıtlı oyuncu olup
olmadığını kontrol eder.
Intent() : Activityler arası geçiş yapmak
için gereklidir.
startActivity(): geçilecek yeni activityi
başlatır.
setOnClickListener():üstüne tıklanıldığında
çalışacak buton metodudur.
onCreate() : yeni bir database oluşturmak
için oluşturulan metoddur.
onUpgrade() : oluşturulan database upgrade
etmek için oluşturulan metoddur.
ekleOyuncu() : oyuncu veritababıba oyuncu
eklemesi için oluşturulan metoddur.
ekleSeviye1e() : seviye1 tablosuna ekleme
yapar.
ekleSeviye2e() : seviye2 tablosuna ekleme
yapar.
seviye1_zorluga_gore_Getir() : seviye1
tablosundan atanmış zorluğa göre bilgileri
getirir.
Seviye seviye2_zorluga_gore_Getir() :
seviye2 tablosundan atanmış zorluğa göre
bilgileri getirir.
Seviye seviye3_zorluga_gore_Getir() :
seviye2 tablosundan atanmış zorluğa göre
bilgileri getirir.
oyuncuSeviyeSkorGuncelle() : seviye
tablosuna kayıtlı oyuncu seviye skorunu
günceller.
aktifOyuncuGetir() : sistem üzerinde aktif
oyuncuyu döndürür.
oyuncuAdiGetir(): aktif oyuncunun adını
döndürür.
oyuncuSkorGetir(): aktif oyuncunun skorunu
getirir.
oyuncununKaldigiSeviyeZorlukGetir():
oyuncunun kaldığı yerden devam edebilmesi
için gereklidir.
2.5. Tasarım345
2.6. Akış Şeması
2.7. Veri Tabanı Diyagramı ( ER Diyagramı )6
2.8. Kaynaklar
[1] https://www.codota.com/code/java/methods/android.widget.Button/callOnClick
[2] https://umiitkose.com/2015/08/java-string-sinifi-ve-metodlari/
[3] https://www.frmtr.com/visual-basic/4751074-textbox-icinde-kelime-arama.html
[4] https://korhanozbek.com/yazilim/867/
[5] https://pybilim.wordpress.com/2013/05/30/donguler-while-for-break-continue/
[6] https://gelecegiyazanlar.turkcell.com.tr/konu/android/egitim/android-201/activity-sinifi
[7] https://gelecegiyazanlar.turkcell.com.tr/konu/android/egitim/android-201/activity-sinifi
[8] https://stackoverflow.com/questions/6264694/how-to-add-message-box-with-ok-button
[9] https://www.sqlitetutorial.net/sqlite-update/
[10]https://medium.com/gokhanyavas/javada-tip-d%C3%B6n%C3%BC%C5%9F%C3%BCmleri-ve-stringi%CC%87fadeler-4d5457497c78
[11]https://stackoverflow.com/questions/56007124/how-do-i-convert-system-currenttimemillis-to-time-format-hhmmss
2.9. Kazanımlar: Geliştirdiğimiz bu projede SQllite database ve Android ile mobil programla deneyimi kazanmış olduk.
Karşılaştığımız problemleri araştırarak android programlama üzerine birçok bilgi edinmiş olduk.7
