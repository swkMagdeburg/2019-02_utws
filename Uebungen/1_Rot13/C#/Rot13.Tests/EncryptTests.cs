using System;
using NUnit.Framework;

namespace Rot13.Tests
{
    [TestFixture]
    public class EncryptTests
    {
        private Rot13Security _sut;

        [SetUp]
        public void Setup()
        {
            _sut = new Rot13Security();
        }

        [Test]
        public void EncryptShouldHandleEmptyString()
        {
            // Arrange
            var sut = new Rot13Security();

            // Act
            var actual = sut.Encrypt(string.Empty);

            // Assert
            Assert.That(actual, Is.EqualTo(string.Empty));
        }

        [Test]
        public void EncryptShouldThrowExceptionWhenNull()
        {
            Assert.Throws<ArgumentNullException>(() => _sut.Encrypt(null));
        }

        [TestCase("A", "N")]
        [TestCase("B", "O")]
        [TestCase("C", "P")]
        [TestCase("M", "Z")]
        public void EncryptShouldShiftUpperCaseCharacter(string character, string expected)
        {
            Assert.That(_sut.Encrypt(character), Is.EqualTo(expected));
        }

        [TestCase("a", "N")]
        [TestCase("b", "O")]
        [TestCase("c", "P")]
        [TestCase("m", "Z")]
        public void EncryptShouldUpperCaseAndShiftLowerCaseCharacter(string character, string expected)
        {
            Assert.That(_sut.Encrypt(character), Is.EqualTo(expected));
        }

        [TestCase("N", "A")]
        [TestCase("O", "B")]
        [TestCase("Z", "M")]
        public void EncryptShouldShiftToStartOfAlphabetWhenItsEndIsReached(string character, string expected)
        {
            Assert.That(_sut.Encrypt(character), Is.EqualTo(expected));
        }

        [TestCase("Hello", "URYYB")]
        [TestCase("World", "JBEYQ")]
        [TestCase("Hello, World!", "URYYB, JBEYQ!")]
        public void EncryptShouldWorkWithWords(string word, string expected)
        {
            Assert.That(_sut.Encrypt(word), Is.EqualTo(expected));
        }

        [Test]
        public void EncryptShouldNotShiftSpecialCharacters()
        {
            var specialCharacters = "01234567890, !§$%&/()=[]{}";
            Assert.That(_sut.Encrypt(specialCharacters), Is.EqualTo(specialCharacters));
        }

        [TestCase("Ä", "AE")]
        [TestCase("Ö", "OE")]
        [TestCase("Ü", "UE")]
        public void EncryptShouldConvertUmlauts(string umlaut, string convertedUmlaut)
        {
            Assert.That(_sut.Encrypt(umlaut), Is.EqualTo(_sut.Encrypt(convertedUmlaut)));
        }
    }
}