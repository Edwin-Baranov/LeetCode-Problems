var WordDictionary = function() {
    this.Storage = {};
};

/** 
 * @param {string} word
 * @return {void}
 */
WordDictionary.prototype.addWord = function(word) {
    let pointer = this.Storage;
    for (let char of word) {
        if (!pointer[char]) { pointer[char] = {}}
        pointer = pointer[char];
    }

    pointer.end = true;
};

/** 
 * @param {string} word
 * @return {boolean}
 */
WordDictionary.prototype.search = function(word) {
    const recusionF = (string, storage) => {
        let pointer = storage;
        for (let i = 0; i < string.length; ++i) {
            const char = string[i];
            if (char === '.') {
                for (entry in pointer) {
                    if (recusionF(string.substring(i + 1), pointer[entry])) {
                        return true;
                    }
                }
                return false;
            }
            if (!pointer[char]) {
                return false;
            }
            pointer = pointer[char];
        }
        return !!pointer.end;
    }

    return recusionF(word, this.Storage)
};

/** 
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = new WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */