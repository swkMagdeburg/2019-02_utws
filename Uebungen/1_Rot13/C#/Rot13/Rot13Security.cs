using System;
using System.Linq;
using System.Text;

namespace Rot13
{
    public class Rot13Security
    {
        public string Encrypt(string input)
        {
            if (input == null)
                throw new ArgumentNullException();

            if (string.IsNullOrEmpty(input)) 
                return string.Empty;

            input = input
                .ToUpper()
                .Replace("Ä", "AE")
                .Replace("Ö", "OE")
                .Replace("Ü", "UE");

            var encrypted = new StringBuilder();
            foreach (var character in input)
                encrypted.Append(Shift(character));

            return encrypted.ToString();
        }

        private char Shift(char character)
        {
            var range = Enumerable.Range('A', 26).ToArray();
            if (range.Contains(character))
            {
                var shiftedCode = character + 13;
                if (shiftedCode > range.Max()) 
                    shiftedCode -= 26;

                character = (char) shiftedCode;
            }

            return character;
        }
    }
}